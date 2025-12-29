/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.singlecard

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import pl.gov.coi.common.ui.ds.singlecard.provider.SingleCardPreviewParameterProvider

val SINGLE_CARD_MINIMUM_HEIGHT: Dp = 80.dp

@Deprecated(
  message = "Deprecated",
  replaceWith = ReplaceWith(
    expression = "SingleCard()",
    imports = arrayOf("pl.gov.coi.common.ui.unmapped.singlecard"),
  ),
)
@Composable
fun SingleCard(
  data: SingleCardData,
) {
  when (data) {
    is SingleCardData.Info -> SingleCardInfo(data = data)
    is SingleCardData.Clickable -> SingleCardClickable(data = data)
    is SingleCardData.SelectableRadioButton -> SingleCardSelectableRadioButton(data = data)
    is SingleCardData.SelectableCheckbox -> SingleCardSelectableCheckbox(data = data)
  }
}

@Preview
@Composable
fun SingleCardPreview(
  @PreviewParameter(SingleCardPreviewParameterProvider::class) singleCardData: SingleCardData,
) {
  SingleCard(
    data = singleCardData,
  )
}
