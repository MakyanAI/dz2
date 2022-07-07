////package ru.liga.utils;
////
////import com.github.sh0nk.matplotlib4j.NumpyUtils;
////import com.github.sh0nk.matplotlib4j.Plot;
////import com.github.sh0nk.matplotlib4j.PythonExecutionException;
////import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
////import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
////import org.telegram.telegrambots.meta.api.objects.InputFile;
////import ru.liga.service.Forecaster;
////
////import java.io.File;
////import java.io.IOException;
////import java.util.ArrayList;
////import java.util.List;
////import java.util.stream.Collectors;
////
////public class Photo {
////
////    public InputFile ParseImg() {
////
////
////        SendPhoto sendPhoto = null;
////        SendMessage message = new SendMessage();
////        Forecaster forecaster = new Forecaster();
////        sendPhoto = new SendPhoto();
////
////        List<Double> x = NumpyUtils.linspace(1, 30, 30);
////        List<Double> C = new ArrayList<>(x);
////        List<Double> S = x.stream().map(Math::tan).collect(Collectors.toList());
////
////        Plot plt = Plot.create();
////        plt.plot().add(x, C);
////        plt.plot().add(x, S);
////
////        plt.savefig("1234");
////        try {
////            plt.executeSilently();
////        } catch (IOException e) {
////            throw new RuntimeException(e);
////        } catch (PythonExecutionException e) {
////            throw new RuntimeException(e);
////        }
////
////        sendPhoto.setChatId(update.getMessage().getChatId().toString());
////        //sendPhoto.setPhoto();
////        sendPhoto.setPhoto(new InputFile(new File("C:\\Users\\amakyan\\Desktop\\Java\\DZ_2\\dz2\\1234.png")));
////        //                SendPhoto sendPhoto1 = new SendPhoto().setPhoto("SomeText", new FileInputStream(new File("photo.jpg")));
////
//////            message.setChatId(update.getMessage().getChatId().toString());
//////            message.setText(forecaster.test(update.getMessage().getText()));
//
//
// try {
//         List<Double> x = NumpyUtils.linspace(1, 7, 7);
//        List<Double> c = new ArrayList<>();
//
//        Plot plt = null;
//        plt = Plot.create();
//        for (int i = 0; i < 2; i++) {
//        for (int k = 0; k < listCurrencyForecastYear.size(); k++) {
//        if(i==1){
//        c.add(listCurrencyForecastYear.get(k).getCurs());
//        } else {
//
//        double x1 = (double) new Random().nextInt(30);
//        c.add(x1);
//        }
//
//        }
//        plt.plot().add(x, c);
//        c.clear();
//        plt.title(parsingListCurrencyRate.get(0).getCdx());
//        }
//        plt.show();
//
//        } catch (IOException e) {
//        } catch (PythonExecutionException e) {
//        throw new RuntimeException(e);
//        }
////
////    }
////}
