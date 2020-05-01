
{{/* vim: set filetype=mustache: */}}
{{/*
Expand the name of the chart.
*/}}
{{- define "athenz-zms.name" -}}
{{- default .Chart.Name .Values.nameOverride | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{/*
Create a default fully qualified app name.
We truncate at 63 chars because some Kubernetes name fields are limited to this (by the DNS naming spec).
If release name contains chart name it will be used as a full name.
*/}}
{{- define "athenz-zms.fullname" -}}
{{- printf "%s-%s" .Release.Name "athenz-zms" | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{- define "athenz-zms.chart" -}}
{{- printf "%s-%s" .Chart.Name .Chart.Version | replace "+" "_" | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{/*
Return the proper ZMS image name
*/}}
{{- define "athenz-zms.image" -}}
{{- $registryName := .Values.image.registry -}}
{{- $repositoryName := .Values.image.repository -}}
{{- $tag := .Values.image.tag | toString -}}
{{- if .Values.global }}
    {{- if .Values.global.imageRegistry }}
        {{- printf "%s/%s:%s" .Values.global.imageRegistry $repositoryName $tag -}}
    {{- else -}}
        {{- printf "%s/%s:%s" $registryName $repositoryName $tag -}}
    {{- end -}}
{{- else -}}
    {{- printf "%s/%s:%s" $registryName $repositoryName $tag -}}
{{- end -}}
{{- end -}}

{{/*
Return the proper ZMS setup image name
*/}}
{{- define "athenz-zms.setupImage" -}}
{{- $registryName := .Values.image.registry -}}
{{- $repositoryName := .Values.image.setupRepository -}}
{{- $tag := .Values.image.tag | toString -}}
{{- if .Values.global }}
    {{- if .Values.global.imageRegistry }}
        {{- printf "%s/%s:%s" .Values.global.imageRegistry $repositoryName $tag -}}
    {{- else -}}
        {{- printf "%s/%s:%s" $registryName $repositoryName $tag -}}
    {{- end -}}
{{- else -}}
    {{- printf "%s/%s:%s" $registryName $repositoryName $tag -}}
{{- end -}}
{{- end -}}

{{/*
Return the proper Docker Image Registry Secret Names
*/}}
{{- define "athenz-zms.imagePullSecrets" -}}
{{- if .Values.global }}
{{- if .Values.global.imagePullSecrets }}
imagePullSecrets:
{{- range .Values.global.imagePullSecrets }}
  - name: {{ . }}
{{- end }}
{{- else if .Values.image.pullSecrets }}
imagePullSecrets:
{{- range .Values.image.pullSecrets }}
  - name: {{ . }}
{{- end }}
{{- end -}}
{{- end -}}
{{- end -}}

{{/*
Return the name of the Secret storing the private key and passwords
*/}}
{{- define "athenz-zms.secretName" -}}
{{- if .Values.existingSecret -}}
{{ .Values.existingSecret }}
{{- else -}}
{{ template "athenz-zms.fullname" . }}
{{- end -}}
{{- end -}}

{{/*
Return the name of the TLS Secret
*/}}
{{- define "athenz-zms.tls.secretName" -}}
{{- if .Values.existingTlsSecret -}}
{{ .Values.existingTlsSecret }}
{{- else -}}
{{ template "athenz-zms.fullname" . }}-tls
{{- end -}}
{{- end -}}

{{/*
Return the name of the Secret storing the trusted CA certificates
*/}}
{{- define "athenz-zms.tls.ca.secretName" -}}
{{- if .Values.existingTlsCaSecret -}}
{{ .Values.existingTlsCaSecret }}
{{- else -}}
{{ template "athenz-zms.fullname" . }}-tls-ca
{{- end -}}
{{- end -}}

{{/*
DB service port
*/}}
{{- define "athenz-zms.jdbc.port" -}}
{{ .Values.mariadb.service.port | toString }}
{{- end -}}

{{/*
DB master host
*/}}
{{- define "athenz-zms.jdbc.master.host" -}}
{{- printf "%s.%s.svc.cluster.local" (include "athenz-zms.mariadb.fullname" .) .Release.Namespace -}}
{{- end -}}

{{/*
DB master JDBC URL
*/}}
{{- define "athenz-zms.jdbc.master.url" -}}
{{- printf "jdbc:mysql://%s:%s/%s" (include "athenz-zms.jdbc.master.host" .) (include "athenz-zms.jdbc.port" .) .Values.mariadb.db.name -}}
{{- end -}}

{{/*
DB slave host
*/}}
{{- define "athenz-zms.jdbc.slave.host" -}}
{{- printf "%s.%s.svc.cluster.local" (include "athenz-zms.mariadb.slave.fullname" .) .Release.Namespace -}}
{{- end -}}

{{/*
DB slave JDBC URL
*/}}
{{- define "athenz-zms.jdbc.slave.url" -}}
{{- printf "jdbc:mysql://%s:%s/%s" (include "athenz-zms.jdbc.slave.host" .) (include "athenz-zms.jdbc.port" .) .Values.mariadb.db.name -}}
{{- end -}}

{{/*
****************************************************************
*** Copy from mariadb
****************************************************************
*/}}
{{- define "athenz-zms.mariadb.image" -}}
{{- $registryName := .Values.mariadb.image.registry -}}
{{- $repositoryName := .Values.mariadb.image.repository -}}
{{- $tag := .Values.mariadb.image.tag | toString -}}
{{- if .Values.global }}
    {{- if .Values.global.imageRegistry }}
        {{- printf "%s/%s:%s" .Values.global.imageRegistry $repositoryName $tag -}}
    {{- else -}}
        {{- printf "%s/%s:%s" $registryName $repositoryName $tag -}}
    {{- end -}}
{{- else -}}
    {{- printf "%s/%s:%s" $registryName $repositoryName $tag -}}
{{- end -}}
{{- end -}}

{{/*
****************************************************************
*** Copy from mariadb, with hard-coded chart name
****************************************************************
*/}}
{{- define "athenz-zms.mariadb.fullname" -}}
{{- if .Values.mariadb.fullnameOverride -}}
{{- .Values.mariadb.fullnameOverride | trunc 63 | trimSuffix "-" -}}
{{- else -}}
{{- $name := default "mariadb" .Values.mariadb.nameOverride -}}
{{- if contains $name .Release.Name -}}
{{- printf .Release.Name | trunc 63 | trimSuffix "-" -}}
{{- else -}}
{{- printf "%s-%s" .Release.Name $name | trunc 63 | trimSuffix "-" -}}
{{- end -}}
{{- end -}}
{{- end -}}

{{/*
****************************************************************
*** Copy from mariadb
****************************************************************
*/}}
{{- define "athenz-zms.mariadb.master.fullname" -}}
{{- if .Values.mariadb.replication.enabled -}}
{{- printf "%s-%s" (include "athenz-zms.mariadb.fullname" .) "master" | trunc 63 | trimSuffix "-" -}}
{{- else -}}
{{- include "athenz-zms.mariadb.fullname" . -}}
{{- end -}}
{{- end -}}

{{/*
****************************************************************
*** Copy from mariadb
****************************************************************
*/}}
{{- define "athenz-zms.mariadb.slave.fullname" -}}
{{- printf "%s-%s" (include "athenz-zms.mariadb.fullname" .) "slave" | trunc 63 | trimSuffix "-" -}}
{{- end -}}
