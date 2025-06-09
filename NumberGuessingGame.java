
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        // 2桁の正の整数をランダムに設定
        Random rand = new Random();
        int secretNumber = rand.nextInt(90) + 10; // 10から99までの乱数
        
        int maxAttempts = 5;
        Scanner scanner = new Scanner(System.in);

        System.out.println("数当てゲームを開始します！");
        System.out.println("2桁の正の整数を当ててください。");
        System.out.println("5回まで挑戦できます。");

        for (int i = 1; i <= maxAttempts; i++) {
            System.out.println("\n" + i + "回目の挑戦です。数を入力してください:");
            int userGuess;

            // ユーザーの入力が整数であるかチェック
            try {
                userGuess = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("エラー: 有効な整数を入力してください。");
                continue; // ループの次のイテレーションへ
            }

            if (userGuess == secretNumber) {
                System.out.println("当たり！おめでとうございます！");
                break; // ゲーム終了
            } else {
                System.out.print("外れ！");
                int diff = Math.abs(secretNumber - userGuess);
                if (diff >= 20) {
                    System.out.print("設定された数とは20以上離れています。");
                }

                if (userGuess < secretNumber) {
                    System.out.println("設定された数はもっと大きいです。");
                } else {
                    System.out.println("設定された数はもっと小さいです。");
                }
            }

            if (i == maxAttempts) {
                System.out.println("\n残念！ゲームオーバーです。");
                System.out.println("正解は " + secretNumber + " でした。");
            }
        }

        scanner.close();
    }
}
