/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.checkbox.single

import pl.gov.coi.common.domain.label.toLabel
import pl.gov.coi.common.ui.ds.button.buttontext.ButtonTextData
import pl.gov.coi.common.ui.ds.checkbox.common.model.CheckBoxRowData
import pl.gov.coi.common.ui.ds.checkbox.common.model.CheckBoxType
import pl.gov.coi.common.ui.ds.checkbox.common.model.CheckboxContentType
import pl.gov.coi.common.ui.ds.checkbox.common.model.ClickableTextData
import pl.gov.coi.common.ui.ds.checkbox.single.model.CheckBoxSingleData
import pl.gov.coi.common.ui.ds.link.LinkData
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData

class CheckBoxSinglePPP : CustomPreviewParameterProvider<CheckBoxSingleData>() {
  override val screenShotTestValues: Sequence<ScreenShotTestData<CheckBoxSingleData>> = sequenceOf(
    ScreenShotTestData(
      screenShotTestName = "Default",
      value = CheckBoxSingleData(
        checkbox = getCheckBoxData(),
        type = CheckBoxType.Default,
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "HelperText",
      value = CheckBoxSingleData(
        checkbox = getCheckBoxData(isChecked = true),
        type = CheckBoxType.Helper(helperText = "helper text".toLabel()),
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "ErrorText",
      value = CheckBoxSingleData(
        checkbox = getCheckBoxData(isChecked = true),
        type = CheckBoxType.Error(errorText = "error text".toLabel()),
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "Disabled",
      value = CheckBoxSingleData(
        isEnabled = false,
        checkbox = getCheckBoxData(isChecked = true),
        type = CheckBoxType.Error(errorText = "error text".toLabel()),
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "ContentBox",
      value = CheckBoxSingleData(
        checkbox = getCheckBoxData(),
        type = CheckBoxType.Helper(helperText = "helper text".toLabel()),
        contentType = CheckboxContentType.CONTENT_BOX,
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "Url",
      value = CheckBoxSingleData(
        checkbox = getCheckBoxData(
          clickableTextData = ClickableTextData.Link(
            linkData = LinkData(
              label = "urlText".toLabel(),
              url = "url",
              linkType = LinkData.LinkType.WEBSITE,
              onClick = { url -> println("Checkbox $url clicked") },
            ),
          ),
        ),
        contentType = CheckboxContentType.CONTENT_BOX,
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "CheckBoxTextButton",
      value = CheckBoxSingleData(
        checkbox = getCheckBoxData(
          clickableTextData = ClickableTextData.Button(
            buttonData = ButtonTextData(
              label = "textButton".toLabel(),
              onClick = { println("buttonText clicked") },
            ),
          ),
        ),
        contentType = CheckboxContentType.CONTENT_BOX,
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "UrlWithError",
      value = CheckBoxSingleData(
        checkbox = getCheckBoxData(
          clickableTextData = ClickableTextData.Link(
            linkData = LinkData(
              label = "urlText".toLabel(),
              url = "url",
              linkType = LinkData.LinkType.WEBSITE,
              onClick = { url -> println("Checkbox $url clicked") },
            ),
          ),
        ),
        type = CheckBoxType.Error(errorText = "error text".toLabel()),
      ),
    ),
  )

  private fun getCheckBoxData(
    isChecked: Boolean = false,
    clickableTextData: ClickableTextData? = null,
  ) = CheckBoxRowData(
    isChecked = isChecked,
    onCheckedChange = {},
    label = "Checkbox label".toLabel(),
    clickableTextData = clickableTextData,
  )
}
