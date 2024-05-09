public class HeikinA {
	public static void main(String[] args){

// Kamokuクラスのインスタンスとして、englishを
// 作る
	Kamoku english = new Kamoku(80);
// 同様に、math
	Kamoku math = new Kamoku(70);

// english の name に "英語" を設定する
	english.name = "英語";
	int a = english.getScore();
	System.out.println("英語の点は" + a + "ですね");
	int b;
	b = math.getScore();
	System.out.println("数学の点は" + b + "ですね");
		int ave=(a+b)/2;
		System.out.println("平均点は" + ave + "ですね");


	}
    
}class Kamoku {
	String name;
	int score;
	private int studentid;

	Kamoku(int s) {  // これがコンストラクタ。特殊なメソッド。クラス名と同じ。
		score = s; 
	}

// setScore というメソッドを定義する。
// score に値を設定する。
	public void setScore(int num){
		score = num;
	}

// getScore というメソッドを定義する。
// scoreを返す。
	public int getScore() {
		return score;
	}
}

// メソッド 関数のこと  
//   public 返り値(戻り値return value) 関数名() {
//      中に具体的な処理を書く
//  }

