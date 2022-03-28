#!/usr/bin/env bash

ABSPATH=$(readlink -f $0)
ABSDIR=$(dirname $ABSPATH)
source ${ABSDIR}/profile.sh

function switch_proxy() {
    IDLE_PORT=$(find_idle_port)

    echo "> 전환할 Port: $IDLE_PORT"
    echo "> Port 전환"
    echo "set \$service_url https://127.0.0.1:${IDLE_PORT};" | sudo tee /etc/nginx/conf.d/service-url.inc

    # 포트 전환하면서, 바꾼거말고 다른거 kill
    if [ ${IDLE_PORT} == 8444 ]
    then
      KILL_PORT=8445
      IDLE_PID=$(lsof -ti tcp:${KILL_PORT})
      echo "> ${KILL_PORT} 포트를 종료합니다."
      kill -15 ${IDLE_PID}
    else
      KILL_PORT=8444
      IDLE_PID=$(lsof -ti tcp:${KILL_PORT})
      echo "> ${KILL_PORT} 포트를 종료합니다."
      kill -15 ${IDLE_PID}
    fi

    echo "> 엔진엑스 Reload"
    sudo systemctl reload nginx.service
}