#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

#include "puzzle2.h"

int sw_sum(int *sw, int len) {
  int sum = 0;
  for (int i = 0; i < len; i++) {
    sum += sw[i];
  }
  return sum;
}

void update_sliding_window(int *sw, int lineVal) {
  // values: 1 2 3 4 5 6
  // sw 1  : 1 2 3          : 6
  // sw 2  :   2 3 4        : 9
  // sw 3  :     3 4 5      : 12
  // sw 6  :       4 5 6    : 15
  sw[0] = sw[1];
  sw[1] = sw[2];
  sw[2] = lineVal;
}

int puzzle2(FILE *input) {
    int slidingWindow[3];
    int count = 0;
    int lastSwSum = -1;
    int increases = 0;
    
    char *line = NULL;
    size_t len = 0;
    for (ssize_t read; (read = getline(&line, &len, input)) != -1; ) {
      int lineVal = atoi(line);
      update_sliding_window(slidingWindow, lineVal);
      count++;

      if (count < 3) {
        continue;
      }

      int swSum = sw_sum(slidingWindow, 3); 
      if (lastSwSum > -1 && swSum > lastSwSum) {
        fprintf(stderr, "%d > %d: increasing\n", swSum, lastSwSum);
        increases++;
      } else {
        fprintf(stderr, "%d <= %d: ignoring\n", swSum, lastSwSum);
      }
      lastSwSum = swSum;
    }

    if (line) {
        free(line);
    }
    return increases;
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

    int increases = puzzle2(input);

    printf("%d\n", increases);
    fclose(input);
    
    return 0;
}

