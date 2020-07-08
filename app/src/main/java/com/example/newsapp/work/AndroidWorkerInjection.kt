package com.example.newsapp.work

// TODO: Implement Worker
// object AndroidWorkerInjection {
//    fun inject(worker: Worker) {
//        //TODO : Check not null
//        val application: Any = worker.getApplicationContext()
//        if (application !is HasWorkerInjector) {
//            throw RuntimeException(
//                String.format(
//                    "%s does not implement %s",
//                    application.javaClass.canonicalName,
//                    HasWorkerInjector::class.java.getCanonicalName()
//                )
//            )
//        }
//        val workerInjector: AndroidInjector<Worker> =
//            (application as HasWorkerInjector).workerInjector()
//        checkNotNull(workerInjector, "%s.workerInjector() returned null", application.javaClass)
//        workerInjector.inject(worker)
//    }
// }
