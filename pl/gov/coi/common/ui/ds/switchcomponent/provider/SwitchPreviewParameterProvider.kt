/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.switchcomponent.provider

import pl.gov.coi.common.domain.validators.ValidationState
import pl.gov.coi.common.ui.ds.button.buttontext.ButtonTextData
import pl.gov.coi.common.ui.ds.link.LinkData
import pl.gov.coi.common.ui.ds.switchcomponent.SwitchData
import pl.gov.coi.common.ui.ds.switchcomponent.SwitchExtraType
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData

class SwitchPreviewParameterProvider : CustomPreviewParameterProvider<SwitchData>() {

  override val screenShotTestValues: Sequence<ScreenShotTestData<SwitchData>> = sequenceOf(
    ScreenShotTestData(
      screenShotTestName = "SwitchEnabledStateOFF",
      value = SwitchData.SwitchOnly(
        checked = false,
        onCheckedChange = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "SwitchEnabledStateON",
      value = SwitchData.SwitchOnly(
        checked = true,
        onCheckedChange = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "SwitchDisabledStateOFF",
      value = SwitchData.SwitchOnly(
        enabled = false,
        checked = false,
        onCheckedChange = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "SwitchDisabledStateON",
      value = SwitchData.SwitchOnly(
        checked = true,
        enabled = false,
        onCheckedChange = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "SwitchWithShortText",
      value = SwitchData.SwitchWithText(
        label = "Krótka  treść".toLabel(),
        checked = false,
        onCheckedChange = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "SwitchWithLongTextInvalid",
      value = SwitchData.SwitchWithText(
        label = "Switch component longer description, Lorem ipsum dolor sit amet, consectetur adipiscing elit"
          .toLabel(),
        onCheckedChange = {},
        checked = false,
        validationState = ValidationState.Invalid(
          message = "Komunikat walidacyjny".toLabel(),
        ),
      ),
    ),

    ScreenShotTestData(
      screenShotTestName = "SwitchWithLink",
      value = SwitchData.SwitchWithExtras(
        checked = true,
        enabled = true,
        onCheckedChange = { },
        label = "Switch with link".toLabel(),
        customActionContentDescription = "Pobierz Switch with link".toLabel(),
        type = SwitchExtraType.Link(
          data = LinkData(
            label = "Link".toLabel(),
            linkType = LinkData.LinkType.WEBSITE,
            url = "",
            onClick = {},
          ),
        ),
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "SwitchWithButtonText",
      value = SwitchData.SwitchWithExtras(
        checked = true,
        enabled = true,
        onCheckedChange = { },
        label = "Switch with text button".toLabel(),
        customActionContentDescription = "Zobacz".toLabel(),
        type = SwitchExtraType.TextButton(
          data = ButtonTextData(
            label = "button text label".toLabel(),
            onClick = {},
          ),
        ),
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "SwitchWithLinkInvalid",
      value = SwitchData.SwitchWithExtras(
        checked = true,
        enabled = true,
        onCheckedChange = { },
        label = "Switch with link".toLabel(),
        type = SwitchExtraType.Link(
          data = LinkData(
            label = "Link".toLabel(),
            linkType = LinkData.LinkType.EXTERNAL_APP,
            url = "",
            onClick = {},
          ),
        ),
        validationState = ValidationState.Invalid(
          message = "Komunikat walidacyjny".toLabel(),
        ),
        customActionContentDescription = "Pobierz Switch with link".toLabel(),
      ),
    ),
  )
}
