/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.banner.provider

import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.domain.label.toLabel
import pl.gov.coi.common.ui.ds.banner.BannerData
import pl.gov.coi.common.ui.ds.button.ButtonData
import pl.gov.coi.common.ui.ds.button.buttontext.ButtonTextData
import pl.gov.coi.common.ui.ds.button.common.ButtonSize
import pl.gov.coi.common.ui.ds.button.common.ButtonType
import pl.gov.coi.common.ui.ds.button.common.ButtonVariant
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData

class BannerPreviewParameterProvider : CustomPreviewParameterProvider<BannerData>() {
  override val screenShotTestValues: Sequence<ScreenShotTestData<BannerData>> = sequenceOf(
    ScreenShotTestData(
      screenShotTestName = "BannerInfoWithoutTitle",
      value = provideBannerInfoWithoutTitle(),
    ),
    ScreenShotTestData(
      screenShotTestName = "BannerInfo",
      value = provideBannerInfo(),
    ),
    ScreenShotTestData(
      screenShotTestName = "BannerInfoFull",
      value = provideBannerInfoFull(),
    ),
    ScreenShotTestData(
      screenShotTestName = "BannerInfoErrorWithoutTitle",
      value = provideBannerErrorWithoutTitle(),
    ),
    ScreenShotTestData(
      screenShotTestName = "BannerError",
      value = provideBannerError(),
    ),
    ScreenShotTestData(
      screenShotTestName = "BannerErrorFull",
      value = provideBannerErrorFull(),
    ),
    ScreenShotTestData(
      screenShotTestName = "BannerHighEmphasisInfoWithoutTitle",
      value = provideBannerHighEmphasisInfoWithoutTitle(),
    ),
    ScreenShotTestData(
      screenShotTestName = "BannerHighEmphasisInfo",
      value = provideBannerHighEmphasisInfo(),
    ),
    ScreenShotTestData(
      screenShotTestName = "BannerHighEmphasisInfoFull",
      value = provideBannerHighEmphasisInfoFull(),
    ),
    ScreenShotTestData(
      screenShotTestName = "BannerHighEmphasisErrorWithoutTitle",
      value = provideBannerHighEmphasisErrorWithoutTitle(),
    ),
    ScreenShotTestData(
      screenShotTestName = "BannerHighEmphasisError",
      value = provideBannerHighEmphasisError(),
    ),
    ScreenShotTestData(
      screenShotTestName = "BannerHighEmphasisErrorFull",
      value = provideBannerHighEmphasisErrorFull(),
    ),
  )

  private fun provideBannerInfoWithoutTitle() = BannerData.Info(
    bodyText = (
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
        "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam."
      ).toLabel(),
    iconContentDescription = Label.EMPTY,
  )

  private fun provideBannerInfo() = BannerData.Info(
    title = "Info banner".toLabel(),
    bodyText = (
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
        "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam."
      ).toLabel(),
    iconContentDescription = Label.EMPTY,
  )

  private fun provideBannerInfoFull() = BannerData.Info(
    title = "Info banner".toLabel(),
    bodyText = (
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
        "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam."
      ).toLabel(),
    iconContentDescription = Label.EMPTY,
    buttonData = ButtonTextData(
      label = "Text button".toLabel(),
    ) {},
    onCloseButtonClick = {},
  )

  private fun provideBannerErrorWithoutTitle() = BannerData.Error(
    bodyText = (
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
        "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam."
      ).toLabel(),
    iconContentDescription = Label.EMPTY,
  )

  private fun provideBannerError() = BannerData.Error(
    title = "Error banner".toLabel(),
    bodyText = (
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
        "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam."
      ).toLabel(),
    iconContentDescription = Label.EMPTY,
  )

  private fun provideBannerErrorFull() = BannerData.Error(
    title = "Error banner with very very very very long title".toLabel(),
    bodyText = (
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
        "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam."
      ).toLabel(),
    iconContentDescription = Label.EMPTY,
    buttonData = ButtonTextData(
      label = "Text Button".toLabel(),
    ) {},
    onCloseButtonClick = {},
  )

  private fun provideBannerHighEmphasisInfoWithoutTitle() = BannerData.HighEmphasisInfo(
    bodyText = (
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
        "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam."
      ).toLabel(),
    iconContentDescription = Label.EMPTY,
  )

  private fun provideBannerHighEmphasisInfo() = BannerData.HighEmphasisInfo(
    title = "High emphasis info banner".toLabel(),
    bodyText = (
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
        "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam."
      ).toLabel(),
    iconContentDescription = Label.EMPTY,
  )

  private fun provideBannerHighEmphasisInfoFull() = BannerData.HighEmphasisInfo(
    title = "High emphasis info banner".toLabel(),
    bodyText = (
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
        "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam."
      ).toLabel(),
    iconContentDescription = Label.EMPTY,
    buttonData = ButtonData(
      buttonSize = ButtonSize.Small,
      buttonVariant = ButtonVariant.Secondary(
        reversedColor = true,
      ),
      buttonType = ButtonType.WithText(
        label = "Small Button".toLabel(),
      ),
      onClick = {},
    ),
    onCloseButtonClick = {},
  )

  private fun provideBannerHighEmphasisErrorWithoutTitle() = BannerData.HighEmphasisError(
    bodyText = (
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
        "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam."
      ).toLabel(),
    iconContentDescription = Label.EMPTY,
  )

  private fun provideBannerHighEmphasisError() = BannerData.HighEmphasisError(
    title = "High emphasis error banner".toLabel(),
    bodyText = (
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
        "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam."
      ).toLabel(),
    iconContentDescription = Label.EMPTY,
  )

  private fun provideBannerHighEmphasisErrorFull() = BannerData.HighEmphasisError(
    title = "High emphasis error banner".toLabel(),
    bodyText = (
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
        "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam."
      ).toLabel(),
    iconContentDescription = Label.EMPTY,
    buttonData = ButtonData(
      buttonSize = ButtonSize.Small,
      buttonVariant = ButtonVariant.Secondary(
        reversedColor = true,
      ),
      buttonType = ButtonType.WithText(
        label = "Small Button".toLabel(),
      ),
      onClick = {},
    ),
    onCloseButtonClick = {},
  )
}
