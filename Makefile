.PHONY: test test-clojure test-java clean symlink

test: test-clojure test-java

test-clojure:
	cd clojure && lein test

test-java:
	cd java && mvn test

clean:
	cd clojure && lein clean
	cd java && mvn clean

symlink:
	ln -T -s $(shell pwd)/clojure ../../clojure/qi
	ln -T -s $(shell pwd)/java ../../java/qi
