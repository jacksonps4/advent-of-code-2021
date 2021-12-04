#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>

typedef struct {
    int horizontal;
    int depth;
} position;

position* day2_puzzle1(FILE *input) {
    char *line = NULL;
    size_t len = 0;

    position *pos = malloc(sizeof(position));
    pos->horizontal = 0;
    pos->depth = 0;

    for (ssize_t read; (read = getline(&line, &len, input)) != -1; ) {
      char* movement = strtok(line, " \r\n\t");
      char* delta = strtok(NULL, " \r\n\t");

      fprintf(stderr, "Movement '%s' by '%s'\n", movement, delta);

      int movementAmount = atoi(delta);

      if (strncmp("forward", movement, 7) == 0) {
        pos->horizontal += movementAmount;
      } else if (strncmp("down", movement, 4) == 0) {
        pos->depth += movementAmount;
      } else if (strncmp("up", movement, 2) == 0) {
        pos->depth -= movementAmount;
      } else {
        printf("Error in file - invalid movement type\n");
        exit(1);
      }

      fprintf(stderr, "position = %d, depth = %d\n", pos->horizontal, pos->depth);
    }

    if (line) {
        free(line);
    }
    return pos;
}

int main(int argc, const char* argv[]) {
    const char* filename = argv[1];
    if (filename == NULL) {
       printf("Must specify filename\n");
       return 2;
    }
    FILE *input = fopen(filename, "r");
    if (input == NULL) {
        printf("File %s not found", filename);
        return 1;
    }

    position *pos = day2_puzzle1(input);
    fclose(input);

    printf("horizontal %d; depth %d\n", pos->horizontal, pos->depth);
    printf("horizontal x depth = %d", pos->horizontal * pos->depth);   
    free(pos);

    return 0;
}

