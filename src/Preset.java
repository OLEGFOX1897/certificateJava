import java.util.ArrayList;


public class Preset {
    ArrayList<ToyModel> toysInAutomate = new ArrayList<>();
    ArrayList<ToyModel> toysWin = new ArrayList<>();
    Viewer viewer = new Viewer();


    public void run(int variant) {

        if (variant == 0) {
            toysInAutomate.add(new ToyModel(1, "Бегемот", 2, 0.5));
            toysInAutomate.add(new ToyModel(2, "Акула", 1, 0.5));
            toysInAutomate.add(new ToyModel(3, "Самолетик", 2, 0.7));
            toysInAutomate.add(new ToyModel(4, "Хаги-Ваги", 2, 0.3));
            toysInAutomate.add(new ToyModel(5, "Пикачу", 1, 0.1));
            toysInAutomate.add(new ToyModel(6, "Жирафа", 1, 0.3));
        }
        System.out.println("В автомате сейчас следующие игрушки:");
        System.out.println("__________________________________________________________");
        for (ToyModel toy : toysInAutomate
        ) {
            System.out.println(toy.getStringNameToy());
        }
        System.out.println("__________________________________________________________");
        int choice = viewer.getChoice();
        if (choice == 1) {
            System.out.println("__________________________________________________________");
            if (toysWin.size() == 0) {
                System.out.println("Вы пока ничего не выграли!");
            } else {
                System.out.println("__________________________________________________________");
                System.out.println("Вы выграли следующие игрушки:");
                for (ToyModel toy : toysWin
                ) {
                    System.out.println(toy.getStringNameToy());
                }
            }
            run(1);
        } else if (choice == 2) {
            System.out.println("__________________________________________________________");
            int newId = toysInAutomate.get(toysInAutomate.size() - 1).getId() + 1;
            String newName = viewer.getString("Имя");
            int newCount = viewer.getValue("Количество");
            double newDropToy = Math.random();
            toysInAutomate.add(new ToyModel(newId, newName, newCount, newDropToy));
            run(1);
        } else if (choice == 3) {
            int choiceId = viewer.getValue("id игрушки ");
            for (ToyModel toy : toysInAutomate) {
                if (toy.getId() == choiceId) {
                    double captureProbability = Math.random(); // вероятность захвата игрушки
                    double sumProbability = captureProbability + toy.getDropProbability();
                    if (sumProbability >= 1) {
                        int quantityToy = toy.getQuantityToy() - 1;
                        toy.setQuantityToy(quantityToy);
                        System.out.println("__________________________________________________________");
                        System.out.println("Вы выграли " + toy.getNameToy() + ". Поздравляем!!!");
                        System.out.println("Всего осталось " + toy.getQuantityToy() + " игрушек:" + toy.getNameToy());
                        ToyModel youToy = toy;
                        youToy.setQuantityToy(1);
                        toysWin.add(youToy);
                        if (quantityToy == 0) {
                            toysInAutomate.remove(toy);
                            run(1);
                        }
                    } else {
                        System.out.println("__________________________________________________________");
                        System.out.println("У вас не получилось выграть " + toy.getNameToy() + ". Попробуйте снова!");
                        run(1);
                    }

                }
            }
            System.out.println("__________________________________________________________");
            System.out.println("Игрушки с таким id нет!");
            run(1);
        } else if (choice == 4) {
            System.out.println("__________________________________________________________");
            System.out.println("До новых встречь. Хорошего дня!");
        }
    }
}




