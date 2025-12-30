/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.radiobutton.provider

import android.content.Context
import androidx.compose.runtime.Composable
import pl.gov.coi.common.domain.Mapper
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.domain.label.toLabel
import pl.gov.coi.common.ui.ds.dropdownbutton.DropDownButton
import pl.gov.coi.common.ui.ds.dropdownbutton.DropDownButtonData
import pl.gov.coi.common.ui.preview.CustomWrappedDataPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestDataProvider
import pl.gov.coi.common.ui.preview.WrappedValue
import pl.gov.coi.common.ui.ds.radiobutton.RadioButtonData
import pl.gov.coi.common.ui.ds.radiobutton.common.model.RadioButtonCustomContent
import pl.gov.coi.common.ui.ds.radiobutton.common.model.RadioButtonItemData
import pl.gov.coi.common.ui.ds.radiobutton.common.model.RadioButtonRow
import pl.gov.coi.common.ui.ds.radiobutton.common.model.RadioButtonSupportText
import pl.gov.coi.common.ui.ds.radiobutton.common.model.RadioButtonVariant

class RadioButtonPPP : CustomWrappedDataPreviewParameterProvider<
  Unit,
  RadioButtonData?,
  Mapper<Unit, RadioButtonData?>,
  RadioButtonData,
  >() {

  override fun mapper(context: Context): Mapper<Unit, RadioButtonData?> = object : Mapper<Unit, RadioButtonData?> {
    override fun invoke(p1: Unit): RadioButtonData? = null
  }

  override val screenShotTestValues: Sequence<ScreenShotTestDataProvider<RadioButtonData>> = sequenceOf(
    ScreenShotTestDataProvider(
      screenShotTestName = "RadioButtonDefault",
      wrappedValue = WrappedValue {
        provideRadioButton(
          radioButtonVariant = RadioButtonVariant.Default,
        )
      },
    ),
    ScreenShotTestDataProvider(
      screenShotTestName = "RadioButtonDefaultDisabled",
      wrappedValue = WrappedValue {
        provideRadioButton(
          radioButtonVariant = RadioButtonVariant.Default,
          selectedIndex = 0,
          enabled = false,
        )
      },
    ),
    ScreenShotTestDataProvider(
      screenShotTestName = "RadioButtonDefaultWithOptionals",
      wrappedValue = WrappedValue {
        provideRadioButton(
          radioButtonVariant = RadioButtonVariant.Default,
          selectedIndex = 0,
          label = provideLabel(),
          state = provideHelperText(),
          onClickHelperIcon = {},
          description = provideDescription(),
          content = CustomContent(),
        )
      },
    ),

    ScreenShotTestDataProvider(
      screenShotTestName = "RadioButtonDefaultError",
      wrappedValue = WrappedValue {
        provideRadioButton(
          radioButtonVariant = RadioButtonVariant.Default,
          selectedIndex = 1,
          label = provideLabel(),
          state = provideError(),
        )
      },
    ),
    ScreenShotTestDataProvider(
      screenShotTestName = "RadioButtonContentBox",
      wrappedValue = WrappedValue {
        provideRadioButton(
          radioButtonVariant = RadioButtonVariant.ContentBox,
          selectedIndex = 0,
        )
      },
    ),
    ScreenShotTestDataProvider(
      screenShotTestName = "RadioButtonContentBoxDisabled",
      wrappedValue = WrappedValue {
        provideRadioButton(
          radioButtonVariant = RadioButtonVariant.ContentBox,
          selectedIndex = 0,
          enabled = false,
        )
      },
    ),
    ScreenShotTestDataProvider(
      screenShotTestName = "RadioButtonContentBoxWithOptionals",
      wrappedValue = WrappedValue {
        provideRadioButton(
          radioButtonVariant = RadioButtonVariant.ContentBox,
          selectedIndex = 1,
          label = provideLabel(),
          state = provideHelperText(),
          onClickHelperIcon = {},
          description = provideDescription(),
          content = CustomContent(),
        )
      },
    ),
    ScreenShotTestDataProvider(
      screenShotTestName = "RadioButtonContentBoxError",
      wrappedValue = WrappedValue {
        provideRadioButton(
          radioButtonVariant = RadioButtonVariant.ContentBox,
          selectedIndex = 1,
          label = provideLabel(),
          state = provideError(),
        )
      },
    ),
  )

  private fun provideRadioButton(
    radioButtonVariant: RadioButtonVariant,
    state: RadioButtonSupportText = RadioButtonSupportText.Helper(),
    selectedIndex: Int? = null,
    label: Label? = null,
    description: Label? = null,
    onClickHelperIcon: (() -> Unit)? = null,
    content: RadioButtonCustomContent? = null,
    enabled: Boolean = true,
  ) = RadioButtonData(
    items = listOf(
      RadioButtonRow(
        onClick = {},
        label = provideLabel(),
        content = content,
        item = RadioButtonItemData(
          enabled = enabled,
          isSelected = selectedIndex == 0,
        ),
        description = description,
      ),
      RadioButtonRow(
        onClick = {},
        label = provideLabel(),
        content = content,
        item = RadioButtonItemData(
          enabled = enabled,
          isSelected = selectedIndex == 1,
        ),
      ),
    ),
    radioButtonVariant = radioButtonVariant,
    supportText = state,
    label = label,
    onClickHelperIcon = onClickHelperIcon,
  )

  private fun provideLabel() = "Etykieta".toLabel("")

  private fun provideDescription() = "Description".toLabel("")

  private fun provideHelperText() = RadioButtonSupportText.Helper(helperText = "HelperText".toLabel(""))

  private fun provideError() = RadioButtonSupportText.Error(errorText = "Error".toLabel(""))

  class CustomContent : RadioButtonCustomContent {
    override fun content(): @Composable () -> Unit = {
      DropDownButton(
        data = DropDownButtonData(
          label = "Test".toLabel(""),
          items = listOf(
            "Option 1".toLabel(""),
            "Option 2".toLabel(""),
            "Option 3".toLabel(""),
          ),
          placeholder = "Choose".toLabel(""),
          onClick = {},
        ),
      )
    }
  }
}
