package Telephony;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable {

    private List<String> numbers;

    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.setNumbers(numbers);
        this.setUrls(urls);
    }

    public List<String> getNumbers() {
        return numbers;
    }

    protected void setNumbers(List<String> numbers) {
        this.numbers = numbers;
    }

    public List<String> getUrls() {
        return urls;
    }

    protected void setUrls(List<String> urls) {
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder stringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile("[\\d]+");

        for (String url : urls) {
            Matcher matcher = pattern.matcher(url);
            if (matcher.find()) {
                stringBuilder.append("Invalid URL!" + System.lineSeparator());
                continue;
            }

            stringBuilder.append(String.format("Browsing: %s!%n", url));
        }

        return stringBuilder.toString();
    }

    @Override
    public String call() {
        StringBuilder stringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile("[\\D]+");

        for (String number : numbers) {
            Matcher matcher = pattern.matcher(number);
            if (matcher.find()) {
                stringBuilder.append("Invalid number!" + System.lineSeparator());
                continue;
            }

            stringBuilder.append(String.format("Calling... %s%n", number));
        }

        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.call())
                .append(this.browse());

        return stringBuilder.toString();
    }
}