import kotlinx.coroutines.*

@ObsoleteCoroutinesApi
fun main() {
    runBlocking {

        /*Main thread update in UI driven apps (e.g. Android)
        Needs to be defined in Gradle.
        launch(Dispatchers.Main) {
            println("Main dispatcher. Thread: ${Thread.currentThread().name}")
        }*/

        // Starts the coroutine in the inherited dispatcher that called it
        launch(Dispatchers.Unconfined) {
            println("Unconfined 1. Thread: ${Thread.currentThread().name}")
            delay(100L)
            println("Unconfined 2. Thread: ${Thread.currentThread().name}")
        }

        // Useful for CPU intensive work
        launch(Dispatchers.Default) {
            println("Default. Thread: ${Thread.currentThread().name}")
        }

        // Useful for network communication or reading/writing files
        launch(Dispatchers.IO) {
            println("IO. Thread: ${Thread.currentThread().name}")
        }

        // Forces creation of new thread
        launch(newSingleThreadContext("MyThread")) {
            println("newSingleThreadContext. Thread: ${Thread.currentThread().name}")
        }
    }
}