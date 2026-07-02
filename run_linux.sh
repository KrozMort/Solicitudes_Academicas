#!/usr/bin/env bash
set -e
cd "$(dirname "$0")"
rm -rf out
mkdir -p out
javac -encoding UTF-8 -d out @sources.txt
java -cp out pedidos.patrones.comportamiento.main.Main
