/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.filepicker

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import pl.gov.coi.common.ui.ds.errortext.ErrorText
import pl.gov.coi.common.ui.ds.filepicker.model.FilePickerData
import pl.gov.coi.common.ui.ds.filepicker.model.showAddButton
import pl.gov.coi.common.ui.ds.filepicker.model.showError
import pl.gov.coi.common.ui.ds.filepicker.provider.FilePickerPreviewParameterProvider
import pl.gov.coi.common.ui.preview.WrappedValue
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme
import pl.gov.coi.common.ui.unmapped.cardlist.ColumnCardList
import pl.gov.coi.common.ui.unmapped.cardlist.model.CardListData
import pl.gov.coi.common.ui.unmapped.singlecard.SingleCard

@Composable
fun FilePicker(
  modifier: Modifier = Modifier,
  data: FilePickerData,
) {
  Column(
    modifier = modifier
      .fillMaxWidth()
      .wrapContentHeight(),
  ) {
    if (data.files.isNotEmpty()) {
      ColumnCardList(data = CardListData(singleCardList = data.cardsData))
    }

    if (data.showAddButton) {
      if (data.files.isNotEmpty()) {
        Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing200))
      }

      SingleCard(singleCardData = data.addFileCardData)

      AnimatedVisibility(visible = data.showError) {
        data.errorLabel?.let { errorText ->
          Column {
            Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing100))
            ErrorText(errorText = errorText, ignoreForAccessibility = true)
          }
        }
      }

      Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing100))

      CustomText(
        label = data.combinedRequirements,
        style = AppTheme.typography.bodyMediumRegular,
        color = AppTheme.colors.neutral200,
        ignoreForAccessibility = true,
      )
    }
  }
}

@Preview
@Composable
internal fun FilePickerPreview(
  @PreviewParameter(FilePickerPreviewParameterProvider::class)
  wrappedValue: WrappedValue<FilePickerData>,
) {
  FilePicker(
    modifier = Modifier.background(AppTheme.colors.background),
    data = wrappedValue.value(),
  )
}
