#!/usr/bin/env bash
# find_crude_oil.sh

find . -type f -name 'crude_oil*' -print |
    while IFS= read -r item; do
        sleep 1
        echo "Found: $item"
    done
