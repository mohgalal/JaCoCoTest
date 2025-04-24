import com.google.common.truth.Truth.assertThat
import org.example.Calculate
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CalculateTest {

    lateinit var calcTwoNumbers: Calculate
    @BeforeEach
    fun setup() {
        calcTwoNumbers = Calculate()
    }

    @Test
    fun `Should return summition of two numbersm when provide valid numbers`() {
        // Given
        val num1 = 10
        val num2 = 20

        // When
        val result = calcTwoNumbers.sumTwoNumbers(num1, num2)

        // Then
        assertThat(result).isEqualTo(30)

    }

    @Test
    fun `Should return subtraction of two numbersm when provide valid numbers`() {
        // Given
        val num1 = 20
        val num2 = 10

        // When
        val result = calcTwoNumbers.subTwoNumbers(num1, num2)

        // Then
        assertThat(result).isEqualTo(10)

    }

    @Test
    fun `Should return subtraction2 of two numbersm when provide valid numbers`() {
        // Given
        val num1 = 2
        val num2 = 1


        // When
        val result = calcTwoNumbers.subTwoNumbers(num1, num2)

        // Then
        assertThat(result).isEqualTo(1)

    }

    @Test
    fun `Should return subtraction3 of two numbersm when provide valid numbers`() {
        // Given
        val num1 = 2
        val num2 = 1

        // When
        val result = calcTwoNumbers.subTwoNumbers(num1, num2)

        // Then
        assertThat(result).isEqualTo(1)

    }

}