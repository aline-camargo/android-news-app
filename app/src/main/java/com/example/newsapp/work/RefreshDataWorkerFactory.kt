package com.example.newsapp.work

// class RefreshDataWorkerFactory @Inject constructor(
//    private val workerFactories: Map<Class<out Worker>, @JvmSuppressWildcards Provider<ChildWorkerFactory>>
// ) : WorkerFactory() {
//
//    override fun createWorker(
//        appContext: Context,
//        workerClassName: String,
//        workerParameters: WorkerParameters
//    ): ListenableWorker? {
//        val foundEntry =
//            workerFactories.entries.find { Class.forName(workerClassName).isAssignableFrom(it.key) }
//
//        return if (foundEntry != null) {
//            val factoryProvider = foundEntry.value
//            factoryProvider.get().create(appContext, workerParameters)
//        } else {
//            val workerClass = Class.forName(workerClassName).asSubclass(Worker::class.java)
//            val constructor = workerClass.getDeclaredConstructor(
//                Context::class.java,
//                WorkerParameters::class.java
//            )
//            constructor.newInstance(appContext, workerParameters)
//        }
//    }
// }
