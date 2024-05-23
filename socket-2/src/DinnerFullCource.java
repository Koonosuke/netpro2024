public class DinnerFullCource {

    private Dish[] list = new Dish[5];// [0]-[4]の計5個

	public static void main(String[] args) {

		DinnerFullCource fullcourse = new DinnerFullCource();
		fullcourse.eatAll();
	}

    DinnerFullCource() {
        list[0]=new Dish();
		list[0].setName("特選シーザサラダ");
		list[0].setValune(10);
        list[1]=new Dish();
        list[1].setName("銀しゃり");
        list[1].setValune(2);
        list[2]=new Dish();
        list[2].setName("梅干し");
		list[2].setValune(2);
        list[3]=new Dish();
        list[3].setName("納豆");
		list[3].setValune(1);
        list[4]=new Dish();
        list[4].setName("味噌汁");
		list[4].setValune(1);
}
void eatAll(){
    String str ="";
for(Dish kishi : list){
    str+=kishi.getName()+"は"+kishi.getValune()+"個";
    
} System.out.print(str);
}
}