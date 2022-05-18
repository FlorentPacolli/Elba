import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;  
import java.util.*;

class Solution {
  public static void main(String args[]) {
    File directoryPath = new File("test-cases");
    String contents[] = directoryPath.list();

    for (int k = 0; k < contents.length; k++) {
      String line = "";
      String splitBy = ",";
      try {
      String[][] board = new String[10][20];
        BufferedReader br = new BufferedReader(new FileReader("test-cases\\"+contents[k]));
        int index = 0;
        while ((line = br.readLine()) != null) 
        {
          
          String[] row = line.split(splitBy); 
          board[index] = row;
          index++;
        }

        HashSet < String > seen = new HashSet < > ();
        boolean flag = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
              String ch = board[i][j];
                if (!seen.add(ch + "found in row" + i) ||
                  !seen.add(ch + "found in column" + j) ||
                  !seen.add(ch + "found in box" + i / 3 + "-" + j / 3)
                ) { flag = false; break;}
    
            }

            if(flag == false) break;
      
          }
          if (flag == true) { System.out.println("table" + contents[k] + ": true"); } else {
            System.out.println("table" + contents[k]+": false");
          }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

  }
}