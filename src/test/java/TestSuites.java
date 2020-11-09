import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestSuites {

    private final Rectangle farmSquare = new Rectangle(40, 30, 130, 90);
    private final Rectangle blockSquare = new Rectangle(80, 50, 110, 70);
    private final Farm farm = new Farm(farmSquare, blockSquare);
    private final Dog dog = new Dog(farm, 40, 30);
    private final Sheep sheep = new Sheep(farm, 40, 30);

    @DataProvider
    public Object[][] getDogDataFarm() {
        return new Object[][]{
                {60, 40, true},
                {40, 30, true},
                {130, 90, true},
                {130, 30, true},
                {40, 90, true},
                {-15, 90, false},
                {40, -10, false},
                {-100, 100, false},
                {39, 29, false},
                {41, 31, true},
                {131, 91, false},
                {129, 89, true},

        };
    }

    @DataProvider
    public Object[][] getSheepDataFarm() {
        return new Object[][]{
                {67, 82, true},
                {-10, 15, false},
                {40, 30, true},
                {130, 90, true},
                {130, 30, true},
                {40, 90, true},
                {131, 91, false},
                {129, 89, true},
                {39, 29, false},
                {41, 31, true},
                {-100, 100, false},
                {-100, 90, false},
                {40, -100, false}

        };
    }

    @DataProvider
    public Object[][] getSheepDataBlock() {
        return new Object[][]{
                {100, 60, true},
                {81, 51, true},
                {79, 49, true},
                {80, 50, true},
                {111, 71, true},
                {109, 69, true},
                {110, 70, true},
                {110, 50, true},
                {80, 70, true},
                {-15, 90, false},
                {40, -10, false},
                {-80, -50, false},
                {50, 40, true},
                {90, 40, true},
                {50, 60, true},
                {90, 80, true},
                {120, 60, true}

        };
    }

    @DataProvider
    public Object[][] getDogDataBlock() {
        return new Object[][]{
                {90, 60, false},
                {80, 50, false},
                {110, 70, false},
                {110, 50, false},
                {80, 70, false},
                {-15, 50, false},
                {80, -10, false},
                {-100, 100, false},
                {81, 71, true},
                {111, 71, true},
                {109, 69, false},
                {79, 49, true},
                {90, 40, true},
                {50, 60, true},
                {90, 80, true},
                {120, 60, true}

        };
    }

    @Test(dataProvider = "getDogDataFarm")
    public void checkMoveForDogToFarm(int x, int y, boolean expectedResult) {
        Assert.assertEquals(dog.move(x, y), expectedResult);
    }

    @Test(dataProvider = "getDogDataBlock")
    public void checkMoveForDogToBlock(int x, int y, boolean expectedResult) {
        Assert.assertEquals(dog.move(x, y), expectedResult);
    }

    @Test(dataProvider = "getSheepDataFarm")
    public void checkMoveForSheepToFarm(int x, int y, boolean expectedResult) {
        Assert.assertEquals(sheep.move(x, y), expectedResult);
    }

    @Test(dataProvider = "getSheepDataBlock")
    public void checkMoveForSheepToBlock(int x, int y, boolean expectedResult) {
        Assert.assertEquals(sheep.move(x, y), expectedResult);
    }


}
