package main

import (
	"fmt"
	"log"
	"math/rand"
	"net/http"
	"os"
)

const (
	DEFAULT_PORT = "8080"
)

func FibonacciServer(w http.ResponseWriter, req *http.Request) {
	f := fibonacci()
	for i := 0; i < 75; i++ {
		fmt.Fprintln(w, f())
	}
}

func RandomServer(w http.ResponseWriter, req *http.Request) {
	fmt.Fprintln(w, rand.Float64())
}

func HelloServer(w http.ResponseWriter, req *http.Request) {
	fmt.Fprintln(w, "Hello SAP Cloud Platform!")
}

func main() {
	var port string

	log.Printf("Read now: %+v", os.Getenv("cf_api"))
	if port = os.Getenv("PORT"); len(port) == 0 {
		log.Printf("PORT not set! Use default port  %+v", DEFAULT_PORT)
		port = DEFAULT_PORT
	}

	http.HandleFunc("/", HelloServer)
	http.HandleFunc("/fibonacci", FibonacciServer)
	http.HandleFunc("/random", RandomServer)

	err := http.ListenAndServe(":"+port, nil)
	if err != nil {
		log.Printf("Error while starting the server: ", err)
	}
}

func fibonacci() func() int {
	x, y := 0, 1
	return func() int {
		x, y = y, x+y
		return x
	}
}
