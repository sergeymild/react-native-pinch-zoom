import * as React from 'react';

import {
  Dimensions,
  findNodeHandle,
  FlatList,
  ListRenderItemInfo,
  StyleSheet,
  Text,
  TouchableOpacity,
  View,
} from 'react-native';
import Video from 'react-native-video';
import FastImage from 'react-native-fast-image';
import { PinchZoomView } from 'react-native-pinch-zoom';
import { useEffect, useRef } from 'react';
//http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4
export default function App() {
  function renderItem(info: ListRenderItemInfo<any>) {
    let Component: React.ReactNode;
    if (info.item === 'video') {
      Component = (
        <Video
          autoplay={false}
          paused
          resizeMode={'cover'}
          muted
          source={{
            uri: 'http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4',
          }}
          style={{ width: '100%', height: '100%' }}
        />
      );
    }

    if (info.item === 'image') {
      Component = (
        <FastImage
          source={{
            uri: 'https://en.pimg.jp/054/055/647/1/54055647.jpg',
          }}
          resizeMode={'cover'}
          style={{ width: '100%', height: '100%' }}
        />
      );
    }
    if (info.item === 'view') {
      Component = (
        <View style={{ width: '100%', height: '100%', backgroundColor: 'red' }}>
          <TouchableOpacity onPress={() => console.log('tap')}>
            <Text>Tap onme</Text>
          </TouchableOpacity>
        </View>
      );
    }
    return (
      <PinchZoomView
        disableScrollViewOnPinch
        onTap={() => {
          console.log('=================== onn js');
        }}
        onDoubleTap={() => console.log('=================== do js')}
        style={{
          marginBottom: 20,
          width: Dimensions.get('window').width - 32,
          height: 400,
        }}
      >
        {Component}
      </PinchZoomView>
    );
  }

  return (
    <View style={styles.container}>
      <FlatList
        contentContainerStyle={{ alignItems: 'center', paddingBottom: 100 }}
        data={['image', 'video', 'view']}
        renderItem={renderItem}
        style={{ flex: 1 }}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
