(defn import-spring-bean-class [^String prefix]
  (doseq [$ (filter #(clojure.string/starts-with? % prefix)
                    (java.util.Arrays/asList
                      (.getBeanDefinitionNames spring-context)))]
    (try (load-string (format "(import %s)" $)) (catch Exception e#))
    )
  )
