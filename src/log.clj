(safe-def>
  [org.slf4j.LoggerFactory/getILoggerFactory
   ch.qos.logback.classic.Level/toLevel]
  (defn ^:ls reset-all-logback-logger-level [^String level]
    (doseq [logger (.getLoggerList (org.slf4j.LoggerFactory/getILoggerFactory))]
      (.setLevel logger (ch.qos.logback.classic.Level/toLevel level)))))
