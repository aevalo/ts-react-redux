import './Hello.scss';
import * as React from "react";

export interface HelloProps { compiler: string; framework: string; }

// 'HelloProps' describes the shape of props.
// State is never set so we use the 'undefined' type.
export class Hello extends React.Component<HelloProps, undefined> {
    render() {
        return <h1>Hello from&nbsp;
          <span className='compiler'>{this.props.compiler}</span> and&nbsp;
          <span className='framework'>{this.props.framework}</span>!</h1>;
    }
}
