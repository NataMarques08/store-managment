#!/bin/sh
# wait-for.sh

set -e

host="$1"
shift
cmd="$@"

until nc -z "$host" 3306; do
  >&2 echo "MariaDB não está pronto - esperando..."
  sleep 3
done

>&2 echo "MariaDB está pronto - executando comando"
exec $cmd
