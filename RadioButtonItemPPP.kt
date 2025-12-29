/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.radiobutton.common.radiobuttonitem

import android.content.Context
import pl.gov.coi.common.domain.Mapper
import pl.gov.coi.common.ui.preview.CustomWrappedDataPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestDataProvider
import pl.gov.coi.common.ui.preview.WrappedValue
import pl.gov.coi.common.ui.ds.radiobutton.common.model.RadioButtonItemData

class RadioButtonItemPPP : CustomWrappedDataPreviewParameterProvider<
  Unit,
  RadioButtonItemData?,
  Mapper<Unit, RadioButtonItemData?>,
  RadioButtonItemData,
  >() {

  override fun mapper(context: Context) = object : Mapper<Unit, RadioButtonItemData?> {
    override fun invoke(p1: Unit): RadioButtonItemData? = null
  }

  override val screenShotTestValues: Sequence<ScreenShotTestDataProvider<RadioButtonItemData>> = sequenceOf(
    ScreenShotTestDataProvider(
      screenShotTestName = "RadioButtonItemUnselected",
      wrappedValue = WrappedValue {
        provideRadioButtonItemData(
          enabled = true,
          isSelected = false,
          isError = false,
        )
      },
    ),
    ScreenShotTestDataProvider(
      screenShotTestName = "RadioButtonItemUnselectedDisabled",
      wrappedValue = WrappedValue {
        provideRadioButtonItemData(
          enabled = false,
          isSelected = false,
          isError = false,
        )
      },
    ),
    ScreenShotTestDataProvider(
      screenShotTestName = "RadioButtonItemSelected",
      wrappedValue = WrappedValue {
        provideRadioButtonItemData(
          enabled = true,
          isSelected = true,
          isError = false,
        )
      },
    ),
    ScreenShotTestDataProvider(
      screenShotTestName = "RadioButtonItemSelectedDisabled",
      wrappedValue = WrappedValue {
        provideRadioButtonItemData(
          enabled = false,
          isSelected = true,
          isError = false,
        )
      },
    ),
    ScreenShotTestDataProvider(
      screenShotTestName = "RadioButtonItemUnselectedError",
      wrappedValue = WrappedValue {
        provideRadioButtonItemData(
          enabled = true,
          isSelected = false,
          isError = true,
        )
      },
    ),
    ScreenShotTestDataProvider(
      screenShotTestName = "RadioButtonItemSelectedError",
      wrappedValue = WrappedValue {
        provideRadioButtonItemData(
          enabled = true,
          isSelected = true,
          isError = true,
        )
      },
    ),
  )

  private fun provideRadioButtonItemData(
    enabled: Boolean,
    isSelected: Boolean,
    isError: Boolean,
  ) = RadioButtonItemData(
    enabled = enabled,
    isSelected = isSelected,
    isError = isError,
  )
}
