# GithubRepoList

SUMMARY

I used the MVVM in this project. I simply made a project using the LiveData-RxJava-Retrofit-Observer-Navigation-Espresso-Glide structure using the Github API. Application gets reponse from the Github API using RxJava (with the Single method) and Retrofit structures. Application observes this response with the LiveData method and update the adapter when the reponse comes. It show the list to the user with a RecyclerView on the screen. When the user clicked on an item, It switch to a different fragment using the Navigation method. I use Unit Test and UITest in the project. I do the UI Test with the Espresso library. I use the Glide library for loading images. I also handle the errors under control in the project. For example, I disable some characters for entering an valid url address. Application checks the internet. I use some features in the interface, such as SwipeRefreshListener, which the user likes to use. Before returning a response, Application observes a "Loading" variable with the LiveData method and made the ProgressBar visible on the screen. This is simply the summary of the project. For some codes, there are explanations in the project.

For download APK;
https://dosya.co/3pa8qcto2vgn/app-debug.apk.html
