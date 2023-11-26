package com.example.cryptoapp.model

import java.text.NumberFormat
import java.util.Locale


object FakeCoinsData {

    val lowerBound = 1_000_000
    val upperBound = 1_00_000_000

    val randomNumber = formatToDollars(generateRandomNumber(lowerBound, upperBound))

    val indexList = (1..30).toList()
    val coinsPrice = indexList.map { formatToDollars(generateRandomNumber(lowerBound, upperBound))  }


    val coins = listOf(
        Coin(
            id = "1",
            symbol = "USDT",
            name = "Tether USDT",
            ethAddress = "0xdac17f958d2ee523a2206206994597c13d831ec7",
            price = 1.0,
            volume24h = "$${coinsPrice[0]}",
            photoUrl = "https://cryptologos.cc/logos/tether-usdt-logo.png?v=023"
        ),
        Coin(
            id = "2",
            symbol = "ARB",
            name = "Arbitrum",
            ethAddress = "0xB50721BCf8d664c30412Cfbc6cf7a15145234ad1",
            price = 1.06,
            volume24h = "$${coinsPrice[1]}",
            photoUrl = "https://cryptologos.cc/logos/arbitrum-arb-logo.png?v=010"
        ),
        Coin(
            id = "3",
            symbol = "BTC",
            name = "Bitcoin",
            ethAddress = "0xf205cc2f8a44CB3f2a7a3D5EEc66f5eCB57C1a52",
            price = 45000.0,
            volume24h = "$${coinsPrice[2]}",
            photoUrl = "https://cryptologos.cc/logos/bitcoin-btc-logo.png?v=010"
        ),

        Coin(
            id = "4",
            symbol = "LTC",
            name = "Litecoin",
            ethAddress = "0xD907Acb34CC5bBfbEB08f7981d5Dd63b2070f45E",
            price = 150.0,
            volume24h = "$${coinsPrice[3]}",
            photoUrl = "https://cryptologos.cc/logos/litecoin-ltc-logo.png?v=010"
        ),

        Coin(
            id = "5",
            symbol = "ADA",
            name = "Cardano",
            ethAddress = "0x3EE2200Efb3400fAbB9AacF31297cBdD1d435D47",
            price = 2.0,
            volume24h = "$${coinsPrice[4]}",
            photoUrl = "https://cryptologos.cc/logos/cardano-ada-logo.png?v=010"
        ),
        Coin(
            id = "6",
            symbol = "XLM",
            name = "Stellar",
            ethAddress = "0xc83cE73Fb674f4bD16d228aaDAfD2eA1334b15AE",
            price = 0.5,
            volume24h = "$${coinsPrice[5]}",
            photoUrl = "https://cryptologos.cc/logos/stellar-xlm-logo.png?v=010"
        ),

        Coin(
            id = "7",
            symbol = "LINK",
            name = "Chainlink",
            ethAddress = "0x7bA0Ad4a9855a03C5FAD43953415222Dd71d6c02",
            price = 25.0,
            volume24h = "$${coinsPrice[6]}",
            photoUrl = "https://cryptologos.cc/logos/chainlink-link-logo.png?v=010"
        ),

        Coin(
            id = "8",
            symbol = "DOT",
            name = "Polkadot",
            ethAddress = "0x245a51Cb9A86A7bda1dAc6d606BB9703EE99842b",
            price = 30.0,
            volume24h = "$${coinsPrice[7]}",
            photoUrl = "https://cryptologos.cc/logos/polkadot-new-dot-logo.png?v=010"
        ),
        Coin(
            id = "9",
            symbol = "XRP",
            name = "Ripple",
            ethAddress = "0x25F0d40f7364e76E897e476200d3Df6c8c1F4c36",
            price = 1.5,
            volume24h = "$${coinsPrice[8]}",
            photoUrl = "https://cryptologos.cc/logos/xrp-xrp-logo.png?v=010"

        ),
        Coin(
            id = "10",
            symbol = "BNB",
            name = "Binance Coin",
            ethAddress = "0xB8c77482e45F1F44dE1745F52C74426C631bDD52",
            price = 400.0,
            volume24h = "$${coinsPrice[9]}",
            photoUrl = "https://cryptologos.cc/logos/binance-coin-bnb-logo.png?v=010"
        ),
        Coin(
            id = "11",
            symbol = "DOGE",
            name = "Dogecoin",
            ethAddress = "0xbA2aE424d960c26247Dd6c32edC70B295c744C43",
            price = 0.3,
            volume24h = "$${coinsPrice[10]}",
            photoUrl = "https://cryptologos.cc/logos/dogecoin-doge-logo.png?v=010"
        ),
        Coin(
            id = "12",
            symbol = "UNI",
            name = "Uniswap",
            ethAddress = "0x5C69bEe701ef814a2B6a3EDD4B1652CB9cc5aA6f",
            price = 20.0,
            volume24h = "$${coinsPrice[11]}",
            photoUrl = "https://cryptologos.cc/logos/uniswap-uni-logo.png?v=010"
        ),
        Coin(
            id = "13",
            symbol = "MANA",
            name = "Decentraland",
            ethAddress = "0x0f5d2fb29fb7d3cfee444a200298f468908cc942",
            price = 0.4569,
            volume24h = "$${coinsPrice[12]}",
            photoUrl = "https://cryptologos.cc/logos/decentraland-mana-logo.png?v=029"
        ),
        Coin(
            id = "14",
            symbol = "VET",
            name = "VeChain",
            ethAddress = "0xd850942eF8811f2A866692A623011bDE52a462C1",
            price = 0.1,
            volume24h = "$${coinsPrice[13]}",
            photoUrl = "https://cryptologos.cc/logos/vechain-vet-logo.png?v=010"
        ),
        Coin(
            id = "15",
            symbol = "SOL",
            name = "Solana",
            ethAddress = "0x50B728D8D964fd00C2d0AAD81718b71311feF68a",
            price = 100.0,
            volume24h = "$${coinsPrice[14]}",
            photoUrl = "https://cryptologos.cc/logos/solana-sol-logo.png?v=010"
        ),
        Coin(
            id = "16",
            symbol = "MATIC",
            name = "Polygon",
            ethAddress = "0x7D1AfA7B718fb893dB30A3aBc0Cfc608AaCfeBB0",
            price = 1.0,
            volume24h = "$${coinsPrice[15]}",
            photoUrl = "https://cryptologos.cc/logos/polygon-matic-logo.png?v=010"
        ),

        Coin(
            id = "17",
            symbol = "XMR",
            name = "Monero",
            ethAddress = "0x7D1AfA7B718fb893dB30A3aBc0Cfc608AaCfeBB0",
            price = 200.0,
            volume24h = "$${coinsPrice[16]}",
            photoUrl = "https://cryptologos.cc/logos/monero-xmr-logo.png?v=010"
        ),
        Coin(
            id = "18",
            symbol = "EOS",
            name = "EOS",
            ethAddress = "0x56b6fB708fC5732DEC1Afc8D8556423A2EDcCbD6",
            price = 5.0,
            volume24h = "$${coinsPrice[17]}",
            photoUrl = "https://cryptologos.cc/logos/eos-eos-logo.png?v=010"


        ),
        Coin(
            id = "19",
            symbol = "TRX",
            name = "TRON",
            ethAddress = "0x56b6fB708fC5732DEC1Afc8D8556423A2EDcCbD6",
            price = 0.1,
            volume24h = "$${coinsPrice[18]}",
            photoUrl = "https://cryptologos.cc/logos/tron-trx-logo.png?v=010"

        ),
        Coin(
            id = "20",
            symbol = "NEO",
            name = "NEO",
            ethAddress = "0x56b6fB708fC5732DEC1Afc8D8556423A2EDcCbD6",
            price = 50.0,
            volume24h = "$${coinsPrice[19]}",
            photoUrl = "https://cryptologos.cc/logos/neo-neo-logo.png?v=010"
        ),
        Coin(
            id = "21",
            symbol = "ATOM",
            name = "Cosmos",
            ethAddress = "0x56b6fB708fC5732DEC1Afc8D8556423A2EDcCbD6",
            price = 20.0,
            volume24h = "$${coinsPrice[20]}",
            photoUrl = "https://cryptologos.cc/logos/cosmos-atom-logo.png?v=010"
        ),
        Coin(
            id = "22",
            symbol = "THETA",
            name = "Theta Network",
            ethAddress = "0x56b6fB708fC5732DEC1Afc8D8556423A2EDcCbD6",
            price = 10.0,
            volume24h = "$${coinsPrice[21]}",
            photoUrl = "https://cryptologos.cc/logos/theta-theta-logo.png?v=010"
        ),
        Coin(
            id = "23",
            symbol = "FIL",
            name = "Filecoin",
            ethAddress = "0x56b6fB708fC5732DEC1Afc8D8556423A2EDcCbD6",
            price = 100.0,
            volume24h = "$${coinsPrice[22]}",
            photoUrl = "https://cryptologos.cc/logos/filecoin-fil-logo.png?v=010"
        ),
        Coin(
            id = "24",
            symbol = "AAVE",
            name = "Aave",
            ethAddress = "0x56b6fB708fC5732DEC1Afc8D8556423A2EDcCbD6",
            price = 200.0,
            volume24h = "$${coinsPrice[23]}",
            photoUrl = "https://cryptologos.cc/logos/aave-aave-logo.png?v=010"
        ),
        Coin(
            id = "25",
            symbol = "XEM",
            name = "NEM",
            ethAddress = "0x56b6fB708fC5732DEC1Afc8D8556423A2EDcCbD6",
            price = 0.5,
            volume24h = "$${coinsPrice[24]}",
            photoUrl = "https://cryptologos.cc/logos/nem-xem-logo.png?v=010"
        ),
        Coin(
            id = "26",
            symbol = "KSM",
            name = "Kusama",
            ethAddress = "0x56b6fB708fC5732DEC1Afc8D8556423A2EDcCbD6",
            price = 100.0,
            volume24h = "$${coinsPrice[25]}",
            photoUrl = "https://cryptologos.cc/logos/kusama-ksm-logo.png?v=010"
        ),
        Coin(
            id = "27",
            symbol = "HT",
            name = "Huobi Token",
            ethAddress = "0x56b6fB708fC5732DEC1Afc8D8556423A2EDcCbD6",
            price = 10.0,
            volume24h = "$${coinsPrice[26]}",
            photoUrl = "https://cryptologos.cc/logos/huobi-token-ht-logo.png?v=010"
        ),
        Coin(
            id = "28",
            symbol = "WBTC",
            name = "Wrapped Bitcoin",
            ethAddress = "0x2260FAC5E5542a773Aa44fBCfeDf7C193bc2C599",
            price = 45000.0,
            volume24h = "$${coinsPrice[27]}",
            photoUrl = "https://cryptologos.cc/logos/wrapped-bitcoin-wbtc-logo.png?v=010"
        ),
        Coin(
            id = "29",
            symbol = "DAI",
            name = "Dai",
            ethAddress = "0x6B175474E89094C44Da98b954EedeAC495271d0F",
            price = 1.0,
            volume24h = "$${coinsPrice[28]}",
            photoUrl = "https://cryptologos.cc/logos/multi-collateral-dai-dai-logo.png?v=010"
        ),
    )

    fun generateRandomNumber(lowerBound: Int, upperBound: Int): Int {
        require(lowerBound < upperBound) { "Lower bound must be less than upper bound" }

        val random = java.util.Random()
        return random.nextInt(upperBound - lowerBound + 1) + lowerBound
    }

    fun formatToDollars(amount: Int): String {
        val numberFormat = NumberFormat.getNumberInstance(Locale.US)
        return numberFormat.format(amount)
    }
}

