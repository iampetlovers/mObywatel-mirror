/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.textinput.visualtransformation

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.core.text.isDigitsOnly
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.domain.label.toLabel

private const val POLAND_COUNTRY_CODE = "+48"
private const val PLACEHOLDER_POSTAL_CODE = "__-___"

enum class MaskType(val keyboardType: KeyboardType) : OffsetMapping {
  BLIK(
    keyboardType = KeyboardType.Number,
  ) {
    override fun getPlaceholderValue() = Label.EMPTY
    override fun getTextValue(text: String) = text.run { if (length < 6) this else substring(0..5) }

    override fun getDisplayText(text: AnnotatedString): String {
      val trimmed = getTextValue(text.text)

      return StringBuilder().apply {
        for (i in trimmed.indices) {
          append(trimmed[i])
          if (i == 2) append(" ")
        }
      }.toString()
    }

    override fun filter(text: String): Boolean = text.isDigitsOnly() && text.length <= 6

    override fun originalToTransformed(offset: Int): Int {
      if (offset <= 2) return offset
      if (offset <= 6) return offset + 1
      return 7
    }

    override fun transformedToOriginal(offset: Int): Int {
      if (offset <= 3) return offset
      if (offset <= 7) return offset - 1
      return 6
    }
  },
  POST_CODE(
    keyboardType = KeyboardType.Number,
  ) {
    override fun getPlaceholderValue() = PLACEHOLDER_POSTAL_CODE
      .toLabel(tag = "placeholderValue")

    override fun getTextValue(text: String): String {
      val trimmed = text.run { if (length >= 5) substring(0..4) else this }

      return StringBuilder().apply {
        for (i in trimmed.indices) {
          append(trimmed[i])
          if (i == 1) append("-")
        }
      }.toString()
    }

    override fun getDisplayText(text: AnnotatedString): String {
      return getTextValue(text.text)
    }

    override fun filter(text: String): Boolean = text.isDigitsOnly() && text.length <= 5

    override fun originalToTransformed(offset: Int): Int {
      if (offset <= 1) return offset
      if (offset <= 5) return offset + 1
      return 6
    }

    override fun transformedToOriginal(offset: Int): Int {
      if (offset <= 2) return offset
      if (offset <= 6) return offset - 1
      return 5
    }
  },
  PHONE_COUNTRY_CODE(
    keyboardType = KeyboardType.Number,
  ) {
    private val prefixOffset = POLAND_COUNTRY_CODE.length + 1

    override fun getPlaceholderValue() = Label.EMPTY

    override fun getTextValue(text: String): String = "$POLAND_COUNTRY_CODE $text"

    override fun filter(text: String): Boolean = text.isDigitsOnly() && text.length <= 9

    override fun originalToTransformed(offset: Int): Int {
      return offset + prefixOffset
    }

    override fun transformedToOriginal(offset: Int): Int {
      if (offset < prefixOffset) return 0
      return offset - prefixOffset
    }

    override fun getDisplayText(text: AnnotatedString): String {
      return getTextValue(text.text)
    }
  },
  ;

  /**
   * Returns string displayed in input.
   * For example for BLIK code you want to display 123 456 but you want to type just 123456,
   * for post code you want to display 00-123 but you want to type 00123
   */
  abstract fun getDisplayText(text: AnnotatedString): String

  /**
   * Returns real text input value
   * For example for BLIK code you want to display 123 456 but you want to get just 123456 value,
   * for post code you want to display 00-123 and get the same value as well
   */
  abstract fun getTextValue(text: String): String

  /**
   * Filter input field value
   */
  abstract fun filter(text: String): Boolean

  /**
   * Returns placeholder value to show in textField for concrete maskType
   */
  abstract fun getPlaceholderValue(): Label
}
