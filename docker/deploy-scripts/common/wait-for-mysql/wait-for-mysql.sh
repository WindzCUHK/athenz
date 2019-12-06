#!/bin/sh

set -e

until mysqladmin ping --no-defaults --login-path='/etc/my.cnf' --silent "${@:1}"; do
  echo 'MySQL is unavailable - will sleep 3s...'
  sleep 3
done

echo 'MySQL is up!'
