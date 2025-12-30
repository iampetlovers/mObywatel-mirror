/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

import DesignSystem
import SnapshotTesting
import SwiftUI

public enum SnapshotDevice {
  public enum Mode {
    case `default`
    case scaled(CGFloat)
    case estimatedHeight(CGFloat)
  }

  case iPhone13Mini(Mode = .default)
  case iPhone13ProMax(Mode = .default)

  var sizeName: String {
    switch self {
    case .iPhone13Mini:
      "small"

    case .iPhone13ProMax:
      "large"
    }
  }
}

public func assertSnapshots<Value: View>(
  matching value: @autoclosure () throws -> Value, 
  as devices: [SnapshotDevice] = [.iPhone13Mini(), .iPhone13ProMax()],
  named name: String? = nil, 
  appTheme: AppTheme = AppTheme(), 
  record recording: Bool? = nil, 
  timeout: TimeInterval = 5, 
  precision: Float = 1.0, 
  perceptualPrecision: Float = 0.98, 
  file: StaticString = #file, 
  testName: String = #function, 
  line: UInt = #line
) {
  setupAppearance(appTheme: appTheme)
  for device in devices {
    assertSnapshot(
      of: try value().environment(\.appTheme, appTheme), 
      as: .image(
        precision: precision, 
        perceptualPrecision: perceptualPrecision, 
        layout: .device(config: device.config)
      ), 
      named: ".\(device.sizeName)", 
      record: recording, 
      timeout: timeout, 
      file: file, 
      testName: testName, 
      line: line 
    )
  }
}

public extension SnapshotDevice {
  var config: ViewImageConfig {
    switch self {
    case let .iPhone13Mini(mode):
        .iPhone13Mini.transform(with: mode)

    case let .iPhone13ProMax(mode):
        .iPhone13ProMax.transform(with: mode)
    }
  }
}

private extension ViewImageConfig {
  func transform(with mode: SnapshotDevice.Mode) -> ViewImageConfig {
    switch mode {
    case .default:
      self

    case let .scaled(heightScale):
      self.scaled(height: heightScale)

    case let .estimatedHeight(height):
      self.estimatedHeight(height)
    }
  }

  func estimatedHeight(_ height: CGFloat) -> ViewImageConfig {
    var scaledConfig = self
    scaledConfig.size?.height = height 
    return scaledConfig 
  }

  func scaled(height heightScale: CGFloat) -> ViewImageConfig {
    var scaledConfig = self
    scaledConfig.size?.height *= heightScale 
    return scaledConfig 
  }
}
