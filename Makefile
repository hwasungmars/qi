.PHONY: test clean symlink

test:
	cd clojure && lein test
	cd java && mvn test

clean:
	cd clojure && lein clean
	cd java && mvn clean

symlink:
	ln -T -s $(shell pwd)/clojure ../../clojure/qi
	ln -T -s $(shell pwd)/java ../../java/qi
