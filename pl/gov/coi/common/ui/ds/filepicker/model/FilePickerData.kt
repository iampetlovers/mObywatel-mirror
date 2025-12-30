/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.filepicker.model

import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.domain.label.toLabel
import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.theme.AppTheme
import pl.gov.coi.common.ui.unmapped.singlecard.BodySection
import pl.gov.coi.common.ui.unmapped.singlecard.BodyTitleSection
import pl.gov.coi.common.ui.unmapped.singlecard.DefaultSingleCardData
import pl.gov.coi.common.ui.unmapped.singlecard.LeadingSection
import pl.gov.coi.common.ui.unmapped.singlecard.MediaSection
import pl.gov.coi.common.ui.unmapped.singlecard.SingleCardLabel
import pl.gov.coi.common.ui.utils.textWithDotAndSpaceOrEmpty

data class FilePickerData(
  val addFileLabel: Label,
  val errorLabel: Label?,
  val files: List<PickerFile>,
  val requirements: List<Label>,
  val onAddFileClicked: () -> Unit,
  val maxAllowedFiles: Int,
) {
  internal val cardsData = files.map { file -> file.cardData }

  internal val combinedRequirements = requirements.reduce { combinedRequirements, requirement ->
    combinedRequirements + Label.SPACE + requirement
  }

  internal val addFileCardData = DefaultSingleCardData(
    leadingSection = LeadingSection(
      mediaSection = MediaSection.Icon(
        iconResId = R.drawable.ab016_add,
        iconColor = { AppTheme.colors.primary900 },
      ),
    ),
    bodySection = BodySection(
      title = BodyTitleSection.Title(
        singleCardLabel = SingleCardLabel(
          label = addFileLabel,
          labelColor = { AppTheme.colors.primary900 },
          contentDescription = contentDescription().toLabel("filePicker_contentDescription"),
        ),
      ),
    ),
    onClick = onAddFileClicked,
  )
}

private fun FilePickerData.contentDescription() =
  (addFileLabel.textWithDotAndSpaceOrEmpty() +
    combinedRequirements.textWithDotAndSpaceOrEmpty() +
    errorLabel.textWithDotAndSpaceOrEmpty()).trim()

internal val FilePickerData.showAddButton
  get() = files.size < maxAllowedFiles

internal val FilePickerData.showError
  get() = errorLabel != null
