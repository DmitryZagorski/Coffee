package com.epam.coffeewagon.main;
/*
        import com.epam.coffeewagon.wagon.WagonServiceInterface;
        import org.junit.After;
        import org.junit.Before;
        import org.junit.Rule;
        import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
        import org.junit.jupiter.api.Test;
        import org.mockito.Mockito;

        import java.io.*;

        import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

class LoadingTest {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    void should_add_coffee_to_wagon_automatically_if_first_option_is_chosen() throws IOException {
        // given
        WagonServiceInterface wagonService = Mockito.mock(WagonServiceInterface.class);
        Loading loading = new Loading(wagonService);
        String wagonName = "Happy Wagon";
        double coffeeWeight = 2.0;

        // when
        provideInput("1");
        loading.loadWagon(wagonName, coffeeWeight);

        // then
        Mockito.verify(wagonService).addCoffeeToWagonAutomatically(wagonName, coffeeWeight);
    }
}*/