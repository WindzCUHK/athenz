/*
 * Copyright The Athenz Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import styled from '@emotion/styled';
import React from 'react';

const DomainSectionDiv = styled.div`
    margin: 20px 0;
`;

const DetailsDiv = styled.div`
    display: flex;
    flex-flow: row nowrap;
`;

const StyledAnchor = styled.a`
    color: #3570f4;
    text-decoration: none;
    cursor: pointer;
`;

export default function ServiceInstanceDetails(props) {
    const { details } = props;

    let message = [details.description];

    if (details.url != '') {
        message.push(' For more information click ');
        var link = (
            <StyledAnchor
                onClick={() => window.open(details.url, details.target)}
            >
                here
            </StyledAnchor>
        );
        message.push(link);
    }

    return (
        <DomainSectionDiv>
            <DetailsDiv>
                <p>{message}</p>
            </DetailsDiv>
        </DomainSectionDiv>
    );
}
