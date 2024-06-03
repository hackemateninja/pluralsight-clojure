(ns pluralsight.test)

(defn last-four [serial-num]
	(subs (str serial-num) (- (count (str serial-num)) 4)))

(last-four 12345678)
