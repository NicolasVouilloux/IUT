#include <stdio.h>
#include <stdlib.h>
#include <sys/socket.h>
#include <unistd.h>
#include <time.h>

#define NUM_REQUESTS 10000
#define PRINT_INTERVAL 1000

int main() {
    int sockfd[2];
    if (socketpair(AF_LOCAL, SOCK_STREAM, 0, sockfd) == -1) {
        perror("socketpair failed");
        exit(EXIT_FAILURE);
    }

    pid_t pid = fork();
    if (pid == -1) {
        perror("fork failed");
        exit(EXIT_FAILURE);
    }

    if (pid > 0) {
        // Parent process (Client: pi)
        close(sockfd[1]); // Close unused socket

        int N = 0, M = 0;
        for (int i = 0; i < NUM_REQUESTS; i++) {
            // Request x
            char request = 'x'; // Send a simple request
            write(sockfd[0], &request, sizeof(request));

            double x;
            read(sockfd[0], &x, sizeof(x));

            // Request y
            request = 'y'; // Send a simple request
            write(sockfd[0], &request, sizeof(request));

            double y;
            read(sockfd[0], &y, sizeof(y));

            N++; // Increment total draws
            if (x * x + y * y <= 1.0) {
                M++; // Increment successful draws
            }

            // Print approximation of π every PRINT_INTERVAL requests
            if (N % PRINT_INTERVAL == 0) {
                double pi_approx = (4.0 * M) / N;
                printf("Current approximation of π: %.6f\n", pi_approx);
            }
        }

        close(sockfd[0]); // Close the socket when done
    } else {
        // Child process (Server: draw)
        close(sockfd[0]); // Close unused socket

        srandom(time(NULL)); // Initialize random number generator

        for (int i = 0; i < NUM_REQUESTS * 2; i++) { // Each request needs two numbers
            char request;
            read(sockfd[1], &request, sizeof(request));

            double random_number = (double)random() / RAND_MAX; // Generate random number in [0, 1]
            write(sockfd[1], &random_number, sizeof(random_number));
        }

        close(sockfd[1]); // Close the socket when done
    }

    return 0;
}
