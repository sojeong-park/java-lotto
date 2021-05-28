package step5.utils;

import java.util.Set;

public class ValidationUtils {
    private static final String MATCH_PRICE = "^[0-9\\,]*$";
    private static final String WINNING_NUMBER_COMMA_EXCEPTION = "당첨번호는 쉼표(,)로 구분되어야합니다.";
    private static final String WINNING_NUMBER_NULL_EXCEPTION = "당첨번호를 입력해주세요.";
    private static final String WINNING_NUMBER_SIX_DIGIT_EXCEPTION = "당첨번호는 6자리 숫자로 구성되어야합니다.";
    private static final String WINNING_BONUS_DUPLICATION_EXCEPTION = "보너스볼은 당첨번호와 중복되서는 안됩니다.";
    private static final int LOTTO_END_DIGIT = 6;

    private ValidationUtils() {
        throw new AssertionError();
    }

    public static void isNull(String winningNumbers) {
        if (winningNumbers == null || winningNumbers.isEmpty()) {
            throw new RuntimeException(WINNING_NUMBER_NULL_EXCEPTION);
        }
    }

    public static void validWinningNumbersComma(String winningNumbers) {
        if (!winningNumbers.matches(MATCH_PRICE)) {
            throw new RuntimeException(WINNING_NUMBER_COMMA_EXCEPTION);
        }
    }

    public static void validWinningNumbersDigit(int size) {
        if (size != LOTTO_END_DIGIT) {
            throw new RuntimeException(WINNING_NUMBER_SIX_DIGIT_EXCEPTION);
        }
    }

    public static void validDuplicationNumbers(Set<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new RuntimeException(WINNING_BONUS_DUPLICATION_EXCEPTION);
        }
    }
}