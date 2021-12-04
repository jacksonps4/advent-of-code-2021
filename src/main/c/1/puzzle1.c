#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, const char* argv[]) {
    char *line = NULL;
    size_t len = 0;
    ssize_t read;

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

    int lastVal = -1;
    int count = 0;
    while ((read = getline(&line, &len, input)) != -1) {
      int lineVal = atoi(line);
      if (lastVal == -1) {
        lastVal = lineVal;
        continue;
      }
      if (lineVal > lastVal) {
        fprintf(stderr, "%d > %d: increasing\n", lineVal, lastVal);
        count++;
      } else {
        fprintf(stderr, "%d <= %d: ignoring\n", lineVal, lastVal);
      }
      lastVal = lineVal;
    }

    printf("%d\n", count);
    fclose(input);
    if (line) {
        free(line);
    }
    
    return 0;
}
