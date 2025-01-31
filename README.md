# PokemonTCGApp

PokemonTCGApp is a Kotlin-based Android application that allows users to explore and manage their Pokémon Trading Card Game (TCG) collections. The app provides detailed information about Pokémon cards, including their prices, artists, sets, and more. It leverages modern Android development practices and libraries such as Jetpack Compose, Ktor for networking, and Koin for dependency injection.

## Features

- **Card Details**: View detailed information about individual Pokémon cards, including their name, type, HP, attacks, weaknesses, and more.
- **Price Tracking**: Check the market prices of cards from TCGPlayer, with fallback to "N/A" if the price is unavailable.
- **Set Information**: Browse through different card sets and view their details.
- **Search Functionality**: Search for specific cards by name or other attributes.
- **Offline Support**: Cached data allows for offline access to previously viewed cards and sets.
- **Custom Top App Bar**: A custom top app bar with a centered title and optional back navigation.

## Technologies Used

- **Kotlin**: The primary programming language used for the app.
- **Jetpack Compose**: For building the UI in a declarative manner.
- **Ktor**: For making network requests to the Pokémon TCG API.
- **Koin**: For dependency injection.
- **Coroutines**: For asynchronous programming.
- **Serialization**: For parsing JSON responses from the API.

## Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/ismael-martin_wln/PokemonTCGApp.git
    ```
2. Open the project in Android Studio.
3. Build the project to download all dependencies.
4. Run the app on an emulator or physical device.

## Usage

- **Home Screen**: Displays a list of card sets. Tap on a set to view the cards within it.
- **Card Detail Screen**: Displays detailed information about a selected card, including its price, artist, and set information.
- **Search**: Use the search bar to find specific cards by name.

## API

The app uses the [Pokémon TCG API](https://pokemontcg.io/) to fetch card and set data.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request with your changes.

## License

This project is licensed under the MIT License. See the `LICENSE` file for more details.