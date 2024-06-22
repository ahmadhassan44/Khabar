# Khabar 
An android app that displays news articles to users using a REST API.

## Tools Used:
* Kotlin
* Jetpack Compose for rendering UI
* Dagger Hilt for Dependency Injection
* Room Database to achieve offline first functionality
* MVVM for clean Architecture
* Retrofit for API integration


# Features
* **OnboardingScreens:**
When the user opens the app for the first time, three onboarding screen give the overview of the app
* **HomeScreen:**
In this screen the latest news articles for the API are fetched any rendered into a scrollable list
* **SearchScreen:**
This screen enables the user to search for specific articles based on keywords
* **DetailsScreen:**
This screen pops up whenever the user clicks on an article and shows the entire content on the article. Additionally, this screen allows user to open the article in some browser, share the article through some other app like whatsapp and bookmark the article.
* **BookmarksScreen:**
This screen renders those news articles which were bookmarked/saved by the user. The user can view these saved articles while being offline as well

### App demo: https://drive.google.com/file/d/1-vGopyNRhDe4CmhSYhm2v_IEYquym2lj/view?usp=drive_link

