# GID and UID of the default athenz:athenz user inside the container
GID=$(DOCKER_GID)
UID=$(DOCKER_UID)
GID_ARG := $(if $(GID),--build-arg GID=$(GID),--build-arg GID)
UID_ARG := $(if $(UID),--build-arg UID=$(UID),--build-arg UID)
# docker network name
DOCKER_NETWORK="$${DOCKER_NETWORK:-athenz}"

build:
	DOCKER_BUILDKIT=1 docker build -t rdl-athenz-server -f ./util/rdl-athenz-server/Dockerfile ../rdl/rdl-gen-athenz-server
	DOCKER_BUILDKIT=1 docker build -t athenz-mvn-base -f ./util/athenz-mvn-base/Dockerfile ../
	DOCKER_BUILDKIT=1 docker build -t athenz-builder -f ./util/athenz-builder/Dockerfile ../
	DOCKER_BUILDKIT=1 docker build $(GID_ARG) $(UID_ARG) -t athenz-zms-server -f ./zms/Dockerfile ../
	DOCKER_BUILDKIT=1 docker build $(GID_ARG) $(UID_ARG) -t athenz-zts-server -f ./zts/Dockerfile ../
	DOCKER_BUILDKIT=1 docker build $(GID_ARG) $(UID_ARG) -t athenz-ui -f ./ui/Dockerfile ../ui
	DOCKER_BUILDKIT=1 docker build -t athenz-zms-db -f ./db/zms/Dockerfile ../servers/zms/schema
	DOCKER_BUILDKIT=1 docker build -t athenz-zts-db -f ./db/zts/Dockerfile ../servers/zts/schema
	DOCKER_BUILDKIT=1 docker build -t athenz-conf -f ./util/athenz-conf/Dockerfile ../
	DOCKER_BUILDKIT=1 docker build -t athenz-setup-env -f ./setup-scripts/Dockerfile ../
	# DOCKER_BUILDKIT=1 docker build -t athenz-zms-cli -f ./util/zms-cli/Dockerfile ../
	# DOCKER_BUILDKIT=1 docker build -t athenz-cli-util -f ./util/Dockerfile ../

deploy-dev:
	# self signed
	docker run --rm -t -v "../:/athenz" --user "$(shell id -u):$(shell id -g)" athenz-setup-env /athenz/docker/setup-scripts/self-signed-certificates.sh
	# ZMS
	docker run --rm -t -v "../:/athenz" --user "$(shell id -u):$(shell id -g)" athenz-setup-env /athenz/docker/setup-scripts/zms-auto-config.sh
	sh "./deploy-scripts/zms-deploy.sh"
	docker run --rm -t --network="$(DOCKER_NETWORK)" -v "../:/athenz" --user "$(shell id -u):$(shell id -g)" athenz-setup-env /athenz/docker/deploy-scripts/zms-debug.sh
	# ZTS
	docker run --rm -t --network="$(DOCKER_NETWORK)" -v "../:/athenz" --user "$(shell id -u):$(shell id -g)" athenz-setup-env /athenz/docker/setup-scripts/zts-auto-config.sh
	sh "./deploy-scripts/zts-deploy.sh"
	docker run --rm -t --network="$(DOCKER_NETWORK)" -v "../:/athenz" --user "$(shell id -u):$(shell id -g)" athenz-setup-env /athenz/docker/deploy-scripts/zts-debug.sh

setup-docker-network:
	docker network create --subnet $${DOCKER_NETWORK_SUBNET:-172.21.0.0/16} $(DOCKER_NETWORK)

remove-all: remove-containers remove-networks remove-files
remove-containers:
	docker ps -a | grep athenz- | awk '{print $$1}' | xargs --no-run-if-empty docker stop
	docker ps -a | grep athenz- | awk '{print $$1}' | xargs --no-run-if-empty docker rm
remove-networks:
	docker network rm $(DOCKER_NETWORK) || true
remove-files:
	# rm -rf ./jars
	rm -rf ./logs
	rm -rf ./zts/var/zts_store

clean: remove-all
	docker image rm wait-for-mysql || true
	docker image rm rdl-athenz-server || true
	docker image rm athenz-mvn-base || true
	docker image rm athenz-builder || true
	docker image rm athenz-zms-server || true
	docker image rm athenz-zts-server || true
	docker image rm athenz-ui || true
	docker image rm athenz-zms-db || true
	docker image rm athenz-zts-db || true
	docker image rm athenz-conf || true
	# docker image rm athenz-zms-cli || true
	# docker image rm athenz-cli-util || true
