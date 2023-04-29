# react-native-pinch-zoom

## About the project
Replicate easily the Instagram zooming feature for React Native


![](./ezgif-3-657bb85fc2.gif)

## Installation

```sh
"react-native-pinch-zoom": "sergeymild/react-native-pinch-zoom#0.0.1"
```

## Usage

```js
import { PinchZoomView } from "react-native-pinch-zoom";

// ...

<PinchZoomView disableScrollViewOnPinch>
  <Video
    resizeMode={'cover'}
    muted
    source={{
      uri: 'http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4',
    }}
    style={{ width: '100%', height: '100%' }}
  />
</PinchZoomView>
```

## Contributing]

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
