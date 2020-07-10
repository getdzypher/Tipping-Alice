# Tipping Alice (Ethereum Telegram Tipping Wallet)

Tipping Alice uses the library [Web3j](https://github.com/web3j/web3j)

Features Telegram Wallet:
+ Wallet Generate/Delete
+ Recovery Wallet by 12 seed code phrases
+ Obtaining credential from file wallet (Json)
+ Sending Ether with Smart Contract (Fee for transaction 0.001 Ether ~ 0.2$). Method TransactionEth()
+ Sending Ether without Smart Contract (Web3J). Method Transaction()
+ Sending token ERC20
+ Get Balance
  1. Ether
  2. Token
+ Get Token information
  1. Token name
  2. Token symbol
+ Transaction list from etherscan.io (need ApiKey)
+ Commands /send, /tips for templates transactions
	example use commands: /tips 0x0000000000000000000000000000000 1 (Space separated values).
+ Create QR Code for Ether Address
+ Edit GasProce and GasLimit

