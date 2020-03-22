(ns adventura.echo
  (:import [jline.console ConsoleReader])
  )

(defn show-keystroke []
    (loop []
      (print "Enter a keystroke: ")
      (flush)
      (let [cr (ConsoleReader.)
            input (.readLine cr)]
        (do 
          (println input)
          (flush)
          (recur)
          ))))

(show-keystroke)
