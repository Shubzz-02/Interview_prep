package com.company.Zoho.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Program1 {

    static int[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter value of N: ");
        int n = Integer.parseInt(br.readLine());
        System.out.print("Enter the label number limit: ");
        arr = new int[n][n];
        int l = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = (int) Math.floor(Math.random() * (l - 1 + 1) + 1);
            }
        }
        System.out.println("The bord after placing the random numbers within limits");
        int id = 1;
        for (int[] i : arr) {
            System.out.println(id++ + " " + Arrays.toString(i));
        }
        int o;
        do {
            System.out.println("1. Modify the label number");
            System.out.println("2. Continue to remove");
            System.out.println("3. remove all adjacent");
            System.out.println("4. Exit");
            System.out.print("Enter your option: ");
            o = Integer.parseInt(br.readLine());
            if (o == 1) {
                System.out.print("Enter position: ");
                int[] rc = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
                modifyBlock(arr, rc, br);
                display();
            }
            if (o == 2) {
                System.out.println("Enter (X,Y) position: ");
                int[] xy = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
                xy[0]--;
                xy[1]--;
                modifyArray(arr, xy[0], xy[1], n, l, 0);
//                System.out.println("Same number-labeled adjacent block position: ");
//                int[] ad = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
//                ad[0]--;
//                ad[1]--;
//                if (xy[1] == ad[1]) {
//                    for (int i = ad[0]; i >= 0; i--) {
//                        if ((i - 2) >= 0) {
//                            int temp = arr[i - 2][ad[1]];
//                            arr[i][ad[1]] = temp;
//                        } else {
//                            arr[i][ad[1]] = (int) Math.floor(Math.random() * (l - 1 + 1) + 1);
//                        }
//                    }
//                } else if (xy[0] == ad[0]) {
//                    for (int i = xy[1]; i >= 0; i--) {
//                        if ((i - 1) >= 0) {
//                            int temp = arr[i - 1][xy[0]];
//                            arr[i][xy[0]] = temp;
//                        } else {
//                            arr[i][ad[1]] = (int) Math.floor(Math.random() * (l - 1 + 1) + 1);
//                        }
//                    }
//                }
                display();
            }
            if (o == 3) {
                System.out.print("Enter position: ");
                int[] rc = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
                removeAdjacent(arr, rc[0] - 1, rc[1] - 1, n, l);
                System.out.println();
                display();
            }
        } while (o < 4);
    }

    private static void removeAdjacent(int[][] arr, int x, int y, int n, int l) {
        System.out.print("(" + (x + 1) + "," + (y + 1) + ")  ");
        int temp = arr[x][y];
        int i = x;
        while (i >= 0) {
            if (i - 1 >= 0) {
                int temp1 = arr[i - 1][y];
                arr[i][y] = temp1;
            } else {
                arr[i][y] = (int) Math.floor(Math.random() * (l - 1 + 1) + 1);
            }
            i--;
        }
        /*
             5
             2
             2

         */
        if (y + 1 < n && arr[x][y + 1] == temp) {
            removeAdjacent(arr, x, y + 1, n, l);
        } else if (x + 1 < n && arr[x + 1][y] == temp) {
            removeAdjacent(arr, x + 1, y, n, l);
        } else if (y - 1 >= 0 && arr[x][y - 1] == temp) {
            removeAdjacent(arr, x, y - 1, n, l);
        } else if (x - 1 > -0 && arr[x - 1][y] == temp) {
            removeAdjacent(arr, x - 1, y, n, l);
        }
    }

    private static void modifyBlock(int[][] arr, int[] rc, BufferedReader br) throws IOException {
        System.out.print("Enter new label number: ");
        arr[rc[0] - 1][rc[1] - 1] = Integer.parseInt(br.readLine());
        System.out.println("After updating");
    }


    private static void modifyArray(int[][] arr, int x, int y, int n, int l, int o) {
        Boolean check = checkSquare(x, y, n, l);
        if (!check) {
            if (x + 1 < n && arr[x][y] == arr[x + 1][y]) {
                System.out.println(" Same number labelled adjacent block: " + (x + 2) + " " + (y + 1));
                for (int i = x + 1; i >= 0; i--) {
                    if ((i - 2) >= 0) {
                        int temp = arr[i - 2][y];
                        arr[i][y] = temp;
                    } else {
                        arr[i][y] = (int) Math.floor(Math.random() * (l - 1 + 1) + 1);
                    }
                }

            } else if (x - 1 >= 0 && arr[x][y] == arr[x - 1][y]) {
                System.out.println("Same number labelled adjacent block: " + ((x + 1) - 1) + " " + (y + 1));
                for (int i = x; i >= 0; i--) {
                    if ((i - 2) >= 0) {
                        int temp = arr[i - 2][y];
                        arr[i][y] = temp;
                    } else {
                        arr[i][y] = (int) Math.floor(Math.random() * (l - 1 + 1) + 1);
                    }
                }

            } else if (y + 1 < n && arr[x][y] == arr[x][y + 1]) {
                System.out.println("Same number labelled adjacent block: " + (x + 1) + " " + ((y + 1) + 1));

                int i = x;
                while (i >= 0) {
                    if (i - 1 >= 0) {
                        int temp = arr[i - 1][y];
                        arr[i][y] = temp;
                        temp = arr[i - 1][y + 1];
                        arr[i][y + 1] = temp;
                    } else {
                        arr[i][y + 1] = (int) Math.floor(Math.random() * (l - 1 + 1) + 1);
                    }
                    i--;
                }

            } else if (y - 1 >= 0 && arr[x][y] == arr[x][y - 1]) {
                System.out.println("Same number labelled adjacent block: " + (x + 1) + " " + ((y + 1) - 1));
                int i = x;
                while (i >= 0) {
                    if (i - 1 >= 0) {
                        int temp = arr[i - 1][y];
                        arr[i][y] = temp;
                        temp = arr[i - 1][y - 1];
                        arr[i][y - 1] = temp;
                    } else {
                        arr[i][y - 1] = (int) Math.floor(Math.random() * (l - 1 + 1) + 1);
                    }
                    i--;
                }
            }
        }
    }

    private static void display() {
        int id = 1;
        for (int[] i : arr) {
            System.out.println(id++ + " " + Arrays.toString(i));
        }
    }

    private static Boolean checkSquare(int x, int y, int n, int l) {
        if (x + 1 < n && y + 1 < n && arr[x][y] == arr[x][y + 1] && arr[x][y] == arr[x + 1][y + 1] && arr[x][y] == arr[x][y + 1]) {
            remTd(x, y, n, l);
            remTd(x, y + 1, n, l);
            x = x + 1;
            y = y + 1;
            System.out.printf("(%d,%d) -> (%d,%d) -> (%d,%d) -> (%d,%d) -> (%d,%d)\n", x, y, x, y + 1, x + 1, y + 1, x + 1, y, x, y);

            return true;
//            System.out.println("Square path found and the path is : " + "(" + x + ",+" + y + ") -> " + "(" + x + ",+" + (y + 1) + ") -> "
//                    + "(" + (x + 1) + ",+" + (y + 1) + ") -> " + "(" + (x + 1) + ",+" + y + ") -> " + "(" + x + ",+" + y + ")");
        } else if (x + 1 < n && y - 1 >= 0 && arr[x][y] == arr[x + 1][y] && arr[x][y] == arr[x + 1][y - 1] && arr[x][y] == arr[x][y - 1]) {
            remTd(x, y, n, l);
            remTd(x, y - 1, n, l);
            x = x + 1;
            y = y + 1;
            System.out.printf("(%d,%d) -> (%d,%d) -> (%d,%d) -> (%d,%d) -> (%d,%d)\n", x, y, x + 1, y, x + 1, y - 1, x, y - 1, x, y);
            return true;
//            System.out.println("Square path found and the path is : " + "(" + x + ",+" + y + ") -> " + "(" + (x + 1) + ",+" + (y) + ") -> "
//                    + "(" + (x - 1) + ",+" + (y) + ") -> " + "(" + (x - 1) + ",+" + y + ") -> " + "(" + x + ",+" + y + ") ");
        } else if (x - 1 >= 0 && y - 1 >= 0 && arr[x][y] == arr[x][y - 1] && arr[x][y] == arr[x - 1][y - 1] && arr[x][y] == arr[x - 1][y]) {
            remTd(x - 1, y - 1, n, l);
            remTd(x - 1, y, n, l);
            x = x + 1;
            y = y + 1;
            System.out.printf("(%d,%d) -> (%d,%d) -> (%d,%d) -> (%d,%d) -> (%d,%d)\n", x, y, x, y - 1, x - 1, y - 1, x - 1, y, x, y);
            return true;
        } else if (x - 1 >= 0 && y + 1 < n && arr[x][y] == arr[x - 1][y] && arr[x][y] == arr[x - 1][y + 1] && arr[x][y] == arr[x][y + 1]) {
            remTd(x - 1, y, n, l);
            remTd(x - 1, y + 1, n, l);
            x = x + 1;
            y = y + 1;
            System.out.printf("(%d,%d) -> (%d,%d) -> (%d,%d) -> (%d,%d) -> (%d,%d)\n", x, y, x - 1, y, x - 1, y + 1, x, y + 1, x, y);
            return true;
        }
        return false;
    }

    private static void remTd(int x, int y, int n, int l) {
        //System.out.println(" Same number labelled adjacent block: " + (x + 2) + " " + (y + 1));
        for (int i = x + 1; i >= 0; i--) {
            if ((i - 2) >= 0) {
                int temp = arr[i - 2][y];
                arr[i][y] = temp;
            } else {
                arr[i][y] = (int) Math.floor(Math.random() * (l - 1 + 1) + 1);
            }
        }
    }
}
