(safe-def>
  [com.fasterxml.jackson.databind.ObjectMapper]
  (defn ^:ls >json [o]
    (let [^com.fasterxml.jackson.databind.ObjectMapper object-mapper (spring-bean> com.fasterxml.jackson.databind.ObjectMapper)]
      (.writeValueAsString object-mapper o)
      ))
  (defn ^:ls json> [^Class class# ^String json#]
    (let [^com.fasterxml.jackson.databind.ObjectMapper object-mapper (spring-bean> com.fasterxml.jackson.databind.ObjectMapper)]
      (.readValue object-mapper json# class#)
      ))
  (defn ^:ls map2bean [^Class class# map#]
    (json> class# (>json (clojure.walk/keywordize-keys map#))))
  )
