#!/bin/bash
# 署名生成APIのテスト用スクリプト (WSL, Linux, macOS等で実行)

echo "Sending POST request to /api/v1/sign..."

curl -X POST http://localhost:8080/api/v1/sign \
  -H "Content-Type: application/json" \
  -d '{"address":"0x1234567890abcdef1234567890abcdef12345678", "domain":"mywallet.test"}'

echo -e "\n\nDone."
